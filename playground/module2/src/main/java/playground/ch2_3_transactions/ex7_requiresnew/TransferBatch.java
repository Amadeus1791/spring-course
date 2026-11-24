package playground.ch2_3_transactions.ex7_requiresnew;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferBatch {

    private final JdbcTemplate jdbcTemplate;
    private final TransferNote note;

    public TransferBatch(JdbcTemplate jdbcTemplate, TransferNote note) {
        this.jdbcTemplate = jdbcTemplate;
        this.note = note;
    }

    // Transfer, then a note in its own transaction: as in the debrief of task 3.
    @Transactional
    public void transferWithNote() {
        jdbcTemplate.update("UPDATE account SET balance = balance - 5 WHERE id = 1");
        jdbcTemplate.update("UPDATE account SET balance = balance + 5 WHERE id = 2");
        note.record("transferred 5");
    }
}
