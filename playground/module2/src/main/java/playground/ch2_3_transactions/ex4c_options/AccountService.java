package playground.ch2_3_transactions.ex4c_options;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

// On the class: holds for every method. On a method: replaces the settings of the class.
@Service
@Transactional(readOnly = true)
public class AccountService {

    private final JdbcTemplate jdbcTemplate;

    public AccountService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean find() {                       // the class setting: read-only
        return TransactionSynchronizationManager.isCurrentTransactionReadOnly();
    }

    @Transactional                                // the method setting wins: read-write
    public boolean save() {
        return TransactionSynchronizationManager.isCurrentTransactionReadOnly();
    }

    public int drain() {                          // read-only, but it writes
        return jdbcTemplate.update("UPDATE account SET balance = 0 WHERE id = 1");
    }

    @Transactional(timeout = 1)                   // seconds
    public int slowDrain() throws InterruptedException {
        Thread.sleep(1500);
        return jdbcTemplate.update("UPDATE account SET balance = 0 WHERE id = 2");
    }

    public String balances() {
        return jdbcTemplate.queryForList("SELECT owner || ' ' || balance FROM account ORDER BY id", String.class).toString();
    }
}
