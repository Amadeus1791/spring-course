package playground.ch2_3_transactions.ex4b_isolation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

// Two transactions at the same time, on two connections: what does B see of A?
// In Spring you choose the level with @Transactional(isolation = ...), here we set it on the connection.
public class Main {

    public static void main(String[] args) throws SQLException {
        EmbeddedDatabase dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .generateUniqueName(true)
                .addScript("account-schema.sql").addScript("account-data.sql").build();

        System.out.println("--- dirty read: A sets Anna to 10, B reads, A rolls back");
        dirtyRead(dataSource, Connection.TRANSACTION_READ_UNCOMMITTED, "READ_UNCOMMITTED");
        dirtyRead(dataSource, Connection.TRANSACTION_READ_COMMITTED, "READ_COMMITTED  ");

        System.out.println("--- non-repeatable read: B reads Anna, A sets 10 and commits, B reads again");
        nonRepeatableRead(dataSource, Connection.TRANSACTION_READ_COMMITTED, "READ_COMMITTED  ");
        nonRepeatableRead(dataSource, Connection.TRANSACTION_REPEATABLE_READ, "REPEATABLE_READ ");

        System.out.println("--- phantom read: B counts accounts, A opens one for Dora and commits, B counts again");
        phantomRead(dataSource, Connection.TRANSACTION_READ_COMMITTED, "READ_COMMITTED  ");
        phantomRead(dataSource, Connection.TRANSACTION_SERIALIZABLE, "SERIALIZABLE    ");
        dataSource.shutdown();
    }

    // B reads while A's change is not committed yet.
    static void dirtyRead(EmbeddedDatabase dataSource, int level, String name) throws SQLException {
        try (Connection a = dataSource.getConnection(); Connection b = dataSource.getConnection()) {
            a.setAutoCommit(false);                // transaction A
            b.setAutoCommit(false);                // transaction B
            b.setTransactionIsolation(level);      // the level under test, on B
            setAnna(a, 10);                        // A: Anna 10, not committed
            int seen = readAnna(b);                // B: reads Anna
            a.rollback();                          // A: rolls back, Anna is 100 again
            b.commit();
            System.out.println(name + " B sees " + seen);
        }
    }

    // B reads the same row twice, A commits a change in between.
    static void nonRepeatableRead(EmbeddedDatabase dataSource, int level, String name) throws SQLException {
        try (Connection a = dataSource.getConnection(); Connection b = dataSource.getConnection()) {
            a.setAutoCommit(false);                // transaction A
            b.setAutoCommit(false);                // transaction B
            b.setTransactionIsolation(level);      // the level under test, on B
            int first = readAnna(b);               // B: reads Anna
            setAnna(a, 10);                        // A: Anna 10
            a.commit();                            // A: commits
            int second = readAnna(b);              // B: reads Anna again
            b.commit();
            System.out.println(name + " B sees " + first + ", then " + second);
            setAnna(a, 100);                       // back to the start for the next run
            a.commit();
        }
    }

    // B runs the same query twice, A inserts a new row in between.
    static void phantomRead(EmbeddedDatabase dataSource, int level, String name) throws SQLException {
        try (Connection a = dataSource.getConnection(); Connection b = dataSource.getConnection()) {
            a.setAutoCommit(false);                // transaction A
            b.setAutoCommit(false);                // transaction B
            b.setTransactionIsolation(level);      // the level under test, on B
            int first = countAccounts(b);          // B: SELECT COUNT(*) FROM account
            openDora(a);                           // A: INSERT a new account for Dora
            a.commit();                            // A: commits
            int second = countAccounts(b);         // B: the same query again
            b.commit();
            System.out.println(name + " B counts " + first + ", then " + second);
            closeDora(a);                          // back to the start for the next run
            a.commit();
        }
    }

    static void openDora(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO account (id, owner, balance, closed) VALUES (4, 'Dora', 0, FALSE)");
        }
    }

    static void closeDora(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM account WHERE id = 4");
        }
    }

    static int countAccounts(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM account")) {
            resultSet.next();
            return resultSet.getInt(1);
        }
    }

    static void setAnna(Connection connection, int balance) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE account SET balance = " + balance + " WHERE id = 1");
        }
    }

    static int readAnna(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT balance FROM account WHERE id = 1")) {
            resultSet.next();
            return resultSet.getInt(1);
        }
    }
}
