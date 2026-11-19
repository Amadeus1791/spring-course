package labs.lab2_2.task1_exceptions;

import java.util.function.Supplier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

// Lab 2.2, task 1. Predict A to D first, then run.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardDataConfig.class)) {
            JdbcTemplate jdbc = context.getBean(JdbcTemplate.class);

            call("A  holder of card 9999", () ->
                    jdbc.queryForObject("SELECT holder FROM card WHERE number = ?", String.class, "9999"));
            call("B  holder, no WHERE", () ->
                    jdbc.queryForObject("SELECT holder FROM card", String.class));
            call("C  card 4242 a second time", () ->
                    jdbc.update("INSERT INTO card (number, holder, daily_limit) VALUES ('4242', 'Clara', 500)"));
            call("D  the column holdr", () ->
                    jdbc.queryForObject("SELECT holdr FROM card WHERE number = ?", String.class, "4242"));
        }
    }

    // Prints the result, or the exception with its superclasses up to DataAccessException.
    private static void call(String label, Supplier<Object> query) {
        System.out.println(label);
        try {
            System.out.println("   " + query.get());
        } catch (RuntimeException e) {
            StringBuilder chain = new StringBuilder(e.getClass().getSimpleName());
            Class<?> type = e.getClass().getSuperclass();
            while (type != null && !type.getSimpleName().equals("NestedRuntimeException")) {
                chain.append(" < ").append(type.getSimpleName());
                type = type.getSuperclass();
            }
            System.out.println("   " + chain);
        }
    }
}
