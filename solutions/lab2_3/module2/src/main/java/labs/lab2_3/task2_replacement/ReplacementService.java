package labs.lab2_3.task2_replacement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplacementService {

    private final JdbcTemplate jdbcTemplate;

    public ReplacementService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Blocks the old card and issues a new one to the same holder.
    // Solution: both statements in one transaction.
    @Transactional
    public void replace(String oldNumber, String newNumber) {
        jdbcTemplate.update("UPDATE card SET status = 'BLOCKED' WHERE number = ?", oldNumber);
        jdbcTemplate.update("INSERT INTO card (number, holder, status) "
                + "SELECT ?, holder, 'ACTIVE' FROM card WHERE number = ?", newNumber, oldNumber);
    }
}
