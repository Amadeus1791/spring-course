package playground.ch2_3_transactions.ex6_txlogcases;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferNote {

    private final JdbcTemplate jdbcTemplate;

    public TransferNote(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Writes a note in its own transaction.
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void record(String text) {
        jdbcTemplate.update("INSERT INTO note (text) VALUES (?)", text);
    }
}
