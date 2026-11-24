package labs.lab2_3.task4_innerouter;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

// Lab 2.3, task 4. Predict A to D first, then run.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardDataConfig.class)) {
            LimitLog log = context.getBean(LimitLog.class);
            JdbcTemplate jdbc = context.getBean(JdbcTemplate.class);
            TransactionTemplate tx = context.getBean(TransactionTemplate.class);

            run(jdbc, "A", () -> tx.executeWithoutResult(status -> {
                write(jdbc, "A outer");
                try {
                    log.writeAndFail("A inner");
                } catch (IllegalStateException e) {
                    // ignored, the outer part goes on
                }
            }));
            run(jdbc, "B", () -> tx.executeWithoutResult(status -> {
                write(jdbc, "B outer");
                try {
                    log.writeAndFailNew("B inner");
                } catch (IllegalStateException e) {
                    // ignored, the outer part goes on
                }
            }));
            run(jdbc, "C", () -> tx.executeWithoutResult(status -> {
                write(jdbc, "C outer");
                try {
                    log.writeAndFailNested("C inner");
                } catch (IllegalStateException e) {
                    // ignored, the outer part goes on
                }
            }));
            run(jdbc, "D", () -> tx.executeWithoutResult(status -> {
                write(jdbc, "D outer");
                try {
                    log.writeAndFailNoRollback("D inner");
                } catch (IllegalStateException e) {
                    // ignored, the outer part goes on
                }
            }));
        }
    }

    private static void write(JdbcTemplate jdbc, String label) {
        jdbc.update("INSERT INTO limit_change (label) VALUES (?)", label);
    }

    // Empties the table, runs one case, prints what left it and which rows stayed.
    private static void run(JdbcTemplate jdbc, String label, Runnable call) {
        jdbc.update("DELETE FROM limit_change");
        String outcome = "no exception";
        try {
            call.run();
        } catch (RuntimeException e) {
            outcome = e.getClass().getSimpleName();
        }
        List<String> rows = jdbc.queryForList("SELECT label FROM limit_change ORDER BY label", String.class);
        System.out.println(label + ": " + outcome + ", rows: " + rows);
    }
}
