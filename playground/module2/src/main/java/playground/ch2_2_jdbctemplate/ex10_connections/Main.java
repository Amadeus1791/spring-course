package playground.ch2_2_jdbctemplate.ex10_connections;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var jdbcTemplate = context.getBean(JdbcTemplate.class);
        CountingDataSource dataSource = context.getBean(CountingDataSource.class);

        int before = dataSource.connections();
        jdbcTemplate.queryForObject("SELECT COUNT(*) FROM robot", Integer.class);
        jdbcTemplate.update("UPDATE robot SET speed = 6 WHERE id = 1");
        jdbcTemplate.update("UPDATE robot SET speed = 4 WHERE id = 2");
        System.out.println("three calls, connections: " + (dataSource.connections() - before));
        context.close();
    }
}
