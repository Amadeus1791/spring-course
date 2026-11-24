package playground.ch2_3_transactions.ex4a_propagation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Writes one line per transfer attempt. The same INSERT, six propagations.
@Service
public class Journal {

    private final JdbcTemplate jdbcTemplate;

    public Journal(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional                                          // REQUIRED, the default
    public void write(String text) {
        jdbcTemplate.update("INSERT INTO journal (text) VALUES (?)", text);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void writeNew(String text) {
        jdbcTemplate.update("INSERT INTO journal (text) VALUES (?)", text);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void writeMandatory(String text) {
        jdbcTemplate.update("INSERT INTO journal (text) VALUES (?)", text);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void writeSupports(String text) {
        jdbcTemplate.update("INSERT INTO journal (text) VALUES (?)", text);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void writeNotSupported(String text) {
        jdbcTemplate.update("INSERT INTO journal (text) VALUES (?)", text);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void writeNever(String text) {
        jdbcTemplate.update("INSERT INTO journal (text) VALUES (?)", text);
    }

    public List<String> lines() {
        return jdbcTemplate.queryForList("SELECT text FROM journal ORDER BY id", String.class);
    }
}
