package playground.ch2_2_jdbctemplate.ex9_injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var jdbcTemplate = context.getBean(JdbcTemplate.class);

        // A name typed in by a user. No robot has this name.
        String name = "x' OR '1'='1";

        // Glued into the SQL text: the value becomes part of the statement
        List<String> glued = jdbcTemplate.queryForList(
                "SELECT name FROM robot WHERE name = '" + name + "'", String.class);
        System.out.println("glued: " + glued);

        // Bound to ?: the value stays a value
        List<String> bound = jdbcTemplate.queryForList(
                "SELECT name FROM robot WHERE name = ?", String.class, name);
        System.out.println("bound: " + bound);

        // A harmless name with an apostrophe, glued in
        String irish = "O'Brien";
        try {
            jdbcTemplate.queryForList("SELECT name FROM robot WHERE name = '" + irish + "'", String.class);
        } catch (RuntimeException e) {
            System.out.println("O'Brien glued: " + e.getClass().getSimpleName());
        }
        System.out.println("O'Brien bound: "
                + jdbcTemplate.queryForList("SELECT name FROM robot WHERE name = ?", String.class, irish));
        context.close();
    }
}
