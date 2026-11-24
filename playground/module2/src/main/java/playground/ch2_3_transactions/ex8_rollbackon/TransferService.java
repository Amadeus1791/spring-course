package playground.ch2_3_transactions.ex8_rollbackon;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class TransferService {

    private final JdbcTemplate jdbcTemplate;

    public TransferService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Withdraws first, then finds out the balance is too low.
    // A checked exception, no rollbackFor.
    @Transactional
    public void transfer(int fromId, int toId, int amount)
            throws InsufficientFundsException {
        jdbcTemplate.update("UPDATE account SET balance = balance - ? WHERE id = ?",
                amount, fromId);                                        // withdraw
        int balance = jdbcTemplate.queryForObject("SELECT balance FROM account WHERE id = ?",
                Integer.class, fromId);                                 // read it back
        if (balance < 0) {
            throw new InsufficientFundsException("balance " + balance);
        }
        jdbcTemplate.update("UPDATE account SET balance = balance + ? WHERE id = ?", amount, toId);
    }

    public String balances() {
        return jdbcTemplate.queryForList("SELECT owner || ' ' || balance FROM account ORDER BY id", String.class).toString();
    }
}
