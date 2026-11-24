package playground.ch2_3_transactions.ex5_connections;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {

    private final JdbcTemplate jdbcTemplate;

    public TransferService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Moves money from one account to another: withdraw, then deposit.
    @Transactional
    public void transfer(int fromId, int toId, int amount) {
        jdbcTemplate.update("UPDATE account SET balance = balance - ? WHERE id = ?",
                amount, fromId);                                        // withdraw
        boolean closed = jdbcTemplate.queryForObject("SELECT closed FROM account WHERE id = ?",
                Boolean.class, toId);
        if (closed) {
            throw new IllegalArgumentException("account " + toId + " is closed");
        }
        jdbcTemplate.update("UPDATE account SET balance = balance + ? WHERE id = ?",
                amount, toId);                                          // deposit
    }

    // No @Transactional: every call on its own.
    public void transferWithoutTransaction(int fromId, int toId, int amount) {
        jdbcTemplate.update("UPDATE account SET balance = balance - ? WHERE id = ?",
                amount, fromId);                                        // withdraw
        boolean closed = jdbcTemplate.queryForObject("SELECT closed FROM account WHERE id = ?",
                Boolean.class, toId);
        if (closed) {
            throw new IllegalArgumentException("account " + toId + " is closed");
        }
        jdbcTemplate.update("UPDATE account SET balance = balance + ? WHERE id = ?",
                amount, toId);                                          // deposit
    }

    public String balances() {
        return jdbcTemplate.queryForList("SELECT owner || ' ' || balance FROM account ORDER BY id", String.class).toString();
    }
}
