package playground.ch2_3_transactions.ex4a_propagation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// The transfer of ex1_without, with a journal line between withdraw and deposit.
// Six versions, one per propagation of Journal.
@Service
public class TransferService {

    private final JdbcTemplate jdbcTemplate;
    private final Journal journal;

    public TransferService(JdbcTemplate jdbcTemplate, Journal journal) {
        this.jdbcTemplate = jdbcTemplate;
        this.journal = journal;
    }

    @Transactional
    public void transfer(int fromId, int toId, int amount) {
        withdraw(fromId, amount);
        journal.write(fromId + " to " + toId + ", " + amount);             // REQUIRED
        deposit(toId, amount);                                             // throws if closed
    }

    @Transactional
    public void transferNew(int fromId, int toId, int amount) {
        withdraw(fromId, amount);
        journal.writeNew(fromId + " to " + toId + ", " + amount);          // REQUIRES_NEW
        deposit(toId, amount);                                             // throws if closed
    }

    @Transactional
    public void transferMandatory(int fromId, int toId, int amount) {
        withdraw(fromId, amount);
        journal.writeMandatory(fromId + " to " + toId + ", " + amount);    // MANDATORY
        deposit(toId, amount);                                             // throws if closed
    }

    @Transactional
    public void transferSupports(int fromId, int toId, int amount) {
        withdraw(fromId, amount);
        journal.writeSupports(fromId + " to " + toId + ", " + amount);     // SUPPORTS
        deposit(toId, amount);                                             // throws if closed
    }

    @Transactional
    public void transferNotSupported(int fromId, int toId, int amount) {
        withdraw(fromId, amount);
        journal.writeNotSupported(fromId + " to " + toId + ", " + amount); // NOT_SUPPORTED
        deposit(toId, amount);                                             // throws if closed
    }

    @Transactional
    public void transferNever(int fromId, int toId, int amount) {
        withdraw(fromId, amount);
        journal.writeNever(fromId + " to " + toId + ", " + amount);        // NEVER
        deposit(toId, amount);                                             // throws if closed
    }

    private void withdraw(int fromId, int amount) {
        jdbcTemplate.update("UPDATE account SET balance = balance - ? WHERE id = ?", amount, fromId);
    }

    // Throws if the target account is closed.
    private void deposit(int toId, int amount) {
        boolean closed = jdbcTemplate.queryForObject("SELECT closed FROM account WHERE id = ?",
                Boolean.class, toId);
        if (closed) {
            throw new IllegalArgumentException("account " + toId + " is closed");
        }
        jdbcTemplate.update("UPDATE account SET balance = balance + ? WHERE id = ?", amount, toId);
    }

    public String balances() {
        return jdbcTemplate.queryForList("SELECT owner || ' ' || balance FROM account ORDER BY id", String.class).toString();
    }
}
