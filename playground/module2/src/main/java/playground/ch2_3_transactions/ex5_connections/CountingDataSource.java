package playground.ch2_3_transactions.ex5_connections;

import org.springframework.jdbc.datasource.DelegatingDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// Wraps a real DataSource and counts how often somebody asks it for a connection.
public class CountingDataSource extends DelegatingDataSource {

    private int connections;

    public CountingDataSource(DataSource target) {
        super(target);
    }

    @Override
    public Connection getConnection() throws SQLException {
        connections++;
        return super.getConnection();
    }

    public int connections() {
        return connections;
    }
}
