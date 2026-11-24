package labs.lab2_3.task4_innerouter;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// Writes one row into limit_change per call.
@Repository
public class LimitLog {

    private final JdbcTemplate jdbcTemplate;

    public LimitLog(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void writeAndFail(String label) {
        write(label);
        throw new IllegalStateException(label + " failed");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void writeAndFailNew(String label) {
        write(label);
        throw new IllegalStateException(label + " failed");
    }

    @Transactional(propagation = Propagation.NESTED)
    public void writeAndFailNested(String label) {
        write(label);
        throw new IllegalStateException(label + " failed");
    }

    @Transactional(noRollbackFor = IllegalStateException.class)
    public void writeAndFailNoRollback(String label) {
        write(label);
        throw new IllegalStateException(label + " failed");
    }

    private void write(String label) {
        jdbcTemplate.update("INSERT INTO limit_change (label) VALUES (?)", label);
    }
}
