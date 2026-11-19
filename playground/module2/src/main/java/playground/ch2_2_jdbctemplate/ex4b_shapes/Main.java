package playground.ch2_2_jdbctemplate.ex4b_shapes;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

// One method per shape of the result: one value, one row as a map, many values, many rows as maps.
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var jdbc = context.getBean(JdbcTemplate.class);

        String name = jdbc.queryForObject("SELECT name FROM robot WHERE id = ?", String.class, 1);
        System.out.println("one value:     " + name);

        Map<String, Object> row = jdbc.queryForMap("SELECT * FROM robot WHERE id = ?", 1);
        System.out.println("one row, map:  " + row);

        List<String> names = jdbc.queryForList("SELECT name FROM robot ORDER BY id", String.class);
        System.out.println("many values:   " + names);

        List<Map<String, Object>> rows = jdbc.queryForList("SELECT * FROM robot ORDER BY id");
        System.out.println("many rows:     " + rows);
        context.close();
    }
}
