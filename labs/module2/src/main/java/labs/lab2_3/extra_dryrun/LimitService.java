package labs.lab2_3.extra_dryrun;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class LimitService {

    private final JdbcTemplate jdbc;
    private final TransactionTemplate tx;

    public LimitService(JdbcTemplate jdbc, TransactionTemplate tx) {
        this.jdbc = jdbc;
        this.tx = tx;
    }

    // Shows what a new limit would look like, but changes nothing.
    // TODO Lab 2.3, extra task: the new limit must not stay in the database
    public int simulate(String card, int newLimit) {
        return tx.execute(status -> {
            jdbc.update("UPDATE card SET daily_limit = ? WHERE number = ?", newLimit, card);
            return limitOf(card);
        });
    }

    public int limitOf(String card) {
        return jdbc.queryForObject("SELECT daily_limit FROM card WHERE number = ?", Integer.class, card);
    }
}
