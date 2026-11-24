package labs.lab2_3.task2_replacement;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

// Lab 2.3, task 2. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardDataConfig.class)) {
            ReplacementService service = context.getBean(ReplacementService.class);
            JdbcTemplate jdbc = context.getBean(JdbcTemplate.class);

            replace(service, "4242", "5555");   // 5555 is Ben's card
            printCards(jdbc);
            replace(service, "4242", "6666");
            printCards(jdbc);
        }
    }

    private static void replace(ReplacementService service, String oldNumber, String newNumber) {
        String outcome = "done";
        try {
            service.replace(oldNumber, newNumber);
        } catch (RuntimeException e) {
            outcome = e.getClass().getSimpleName();
        }
        System.out.println("replace " + oldNumber + " by " + newNumber + ": " + outcome);
    }

    private static void printCards(JdbcTemplate jdbc) {
        List<String> cards = jdbc.query("SELECT number, holder, status FROM card ORDER BY number",
                (rs, rowNum) -> rs.getString("number") + " " + rs.getString("holder") + " " + rs.getString("status"));
        System.out.println("   " + cards);
    }
}
