package playground.ch2_3_transactions.ex7_requiresnew;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferNote {

    private final JdbcTemplate jdbcTemplate;
    private final HikariDataSource pool;

    public TransferNote(JdbcTemplate jdbcTemplate, HikariDataSource pool) {
        this.jdbcTemplate = jdbcTemplate;
        this.pool = pool;
    }

    // Writes a note in its own transaction and shows how many connections are lent out right now.
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void record(String text) {
        jdbcTemplate.update("INSERT INTO note (text) VALUES (?)", text);
        System.out.println("connections in use: " + pool.getHikariPoolMXBean().getActiveConnections());
    }
}
