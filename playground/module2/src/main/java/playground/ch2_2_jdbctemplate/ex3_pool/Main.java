package playground.ch2_2_jdbctemplate.ex3_pool;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// Without a pool every getConnection() opens a new physical connection. A pool lends out the same ones again.
public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("--- DriverManagerDataSource, no pool");
        borrowThreeTimes(new DriverManagerDataSource("jdbc:h2:mem:plain"));

        System.out.println("--- HikariDataSource, a pool");
        var pool = new HikariDataSource();
        pool.setJdbcUrl("jdbc:h2:mem:pool");
        borrowThreeTimes(pool);
        pool.close();
    }

    private static void borrowThreeTimes(DataSource dataSource) throws SQLException {
        for (int i = 1; i <= 3; i++) {
            try (Connection connection = dataSource.getConnection()) {
                // unwrap: the physical H2 connection behind it
                System.out.println("borrowed: " + connection.unwrap(Connection.class));
            }
        }
    }
}
