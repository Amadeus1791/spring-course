package playground.ch2_2_jdbctemplate.ex5_callbacks;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var jdbcTemplate = context.getBean(JdbcTemplate.class);

        // queryForList: one column, many rows
        List<String> names = jdbcTemplate.queryForList("SELECT name FROM robot ORDER BY name", String.class);
        System.out.println("queryForList:       " + names);

        // RowCallbackHandler: called once per row, returns nothing. Good for row-by-row work: export, printing.
        RowCallbackHandler printer = resultSet -> System.out.println("RowCallbackHandler: "
                + resultSet.getString("name") + " runs at " + resultSet.getInt("speed"));
        jdbcTemplate.query("SELECT name, speed FROM robot ORDER BY id", printer);

        // ResultSetExtractor: gets the whole ResultSet, returns one result of any shape.
        ResultSetExtractor<String> fastest = resultSet -> {
            String name = "none";
            int best = -1;
            int count = 0;
            while (resultSet.next()) {
                count++;
                if (resultSet.getInt("speed") > best) {
                    best = resultSet.getInt("speed");
                    name = resultSet.getString("name");
                }
            }
            return count + " robots, the fastest is " + name;
        };
        System.out.println("ResultSetExtractor: " + jdbcTemplate.query("SELECT name, speed FROM robot", fastest));
        context.close();
    }
}
