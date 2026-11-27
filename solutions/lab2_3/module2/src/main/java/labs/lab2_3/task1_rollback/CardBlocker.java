package labs.lab2_3.task1_rollback;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Each method blocks a card (one row in blocked_card), then something goes wrong, or not.
@Service
public class CardBlocker {

    private final JdbcTemplate jdbcTemplate;

    public CardBlocker(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(noRollbackFor = IllegalStateException.class) // A, solution: the row stays
    public void runtimeException() {
        block("1111");
        throw new IllegalStateException("A failed");
    }

    @Transactional                                              // B
    public void checkedException() throws Exception {
        block("2222");
        throw new Exception("B failed");
    }

    @Transactional                                              // C
    public void caughtInside() {
        block("3333");
        try {
            throw new IllegalStateException("C failed");
        } catch (IllegalStateException e) {
            // the letter to the holder can be sent tomorrow
        }
    }

    public void callsItself() {                                 // D: no annotation
        runtimeException();
    }

    private void block(String number) {
        jdbcTemplate.update("INSERT INTO blocked_card (number) VALUES (?)", number);
    }
}
