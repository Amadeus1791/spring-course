package labs.lab2_2.task3_figures;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

// Figures for the management. Each method: one JdbcTemplate call, each with a different method.
@Component
public class CardReport {

    private final JdbcTemplate jdbc;

    public CardReport(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // queryForObject: one value
    public int totalLimit() {
        return jdbc.queryForObject("SELECT SUM(daily_limit) FROM card", Integer.class);
    }

    // queryForList: one column, many rows
    public List<String> cardsAbove(int minimum) {
        return jdbc.queryForList("SELECT number FROM card WHERE daily_limit > ? ORDER BY number", String.class, minimum);
    }

    // query with a RowCallbackHandler: every row goes into one map, nothing is returned per row
    public Map<String, Integer> limitByHolder() {
        Map<String, Integer> limits = new LinkedHashMap<>();
        jdbc.query("SELECT holder, SUM(daily_limit) AS total FROM card GROUP BY holder ORDER BY holder",
                rs -> {
                    limits.put(rs.getString("holder"), rs.getInt("total"));
                });
        return limits;
    }
}
