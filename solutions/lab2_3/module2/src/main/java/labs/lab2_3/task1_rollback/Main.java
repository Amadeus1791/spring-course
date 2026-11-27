package labs.lab2_3.task1_rollback;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

// Lab 2.3, task 1. Predict A to D first, then run.
public class Main {

    interface Call {
        void run() throws Exception;
    }

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardDataConfig.class)) {
            CardBlocker blocker = context.getBean(CardBlocker.class);
            JdbcTemplate jdbc = context.getBean(JdbcTemplate.class);

            run(jdbc, "A  runtimeException()", blocker::runtimeException);
            run(jdbc, "B  checkedException()", blocker::checkedException);
            run(jdbc, "C  caughtInside()", blocker::caughtInside);
            run(jdbc, "D  callsItself()", blocker::callsItself);
        }
    }

    // Empties the table, runs one case, prints what left the method and how many rows stayed.
    private static void run(JdbcTemplate jdbc, String label, Call call) {
        jdbc.update("DELETE FROM blocked_card");
        String outcome = "no exception";
        try {
            call.run();
        } catch (Exception e) {
            outcome = e.getClass().getSimpleName();
        }
        Integer rows = jdbc.queryForObject("SELECT COUNT(*) FROM blocked_card", Integer.class);
        System.out.println(label + ": " + outcome + ", rows: " + rows);
    }
}
