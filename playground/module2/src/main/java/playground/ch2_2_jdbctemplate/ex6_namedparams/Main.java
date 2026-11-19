package playground.ch2_2_jdbctemplate.ex6_namedparams;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        NamedParameterJdbcTemplate template = context.getBean(NamedParameterJdbcTemplate.class);

        // Each parameter has a name. The order no longer matters.
        var rita = new MapSqlParameterSource()
                .addValue("speed", 7).addValue("name", "Rita").addValue("id", 3);
        int inserted = template.update("INSERT INTO robot (id, name, speed) VALUES (:id, :name, :speed)", rita);
        System.out.println("inserted: " + inserted);

        // A collection as one parameter: (:ids) becomes (?, ?)
        Map<String, Object> ids = Map.of("ids", List.of(1, 3));
        List<String> names = template.queryForList("SELECT name FROM robot WHERE id IN (:ids) ORDER BY id",
                ids, String.class);
        System.out.println("IN list:  " + names);

        // A name without a value: the template stops before the database sees the SQL
        try {
            template.queryForList("SELECT name FROM robot WHERE speed > :min", Map.of("max", 4), String.class);
        } catch (DataAccessException e) {
            System.out.println("missing:  " + e.getClass().getSimpleName());
            System.out.println("  " + e.getMessage());
        }
        context.close();
    }
}
