package playground.ch2_2_jdbctemplate.ex4_template;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var jdbcTemplate = context.getBean(JdbcTemplate.class);

        // One value
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM robot", Integer.class);
        System.out.println("robots:   " + count);

        // Change rows: update returns the number of rows
        int inserted = jdbcTemplate.update("INSERT INTO robot (id, name, speed) VALUES (?, ?, ?)", 3, "Rita", 7);
        System.out.println("inserted: " + inserted);
        int updated = jdbcTemplate.update("UPDATE robot SET speed = speed + 1 WHERE speed < ?", 6);
        System.out.println("updated:  " + updated);

        // Rows into objects: a RowMapper turns one row into one object
        RowMapper<Robot> robotMapper = (resultSet, rowNumber) -> new Robot(
                resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("speed"));
        Robot first = jdbcTemplate.queryForObject("SELECT * FROM robot WHERE id = ?", robotMapper, 1);
        System.out.println("id 1:     " + first);
        List<Robot> fast = jdbcTemplate.query("SELECT * FROM robot WHERE speed > ? ORDER BY id", robotMapper, 4);
        System.out.println("fast:     " + fast);
        context.close();
    }
}
