package playground.ch2_2_jdbctemplate.ex8_sqllog;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

    public static void main(String[] args) {
        // slf4j-simple, before the context starts: the SQL at DEBUG, the parameters at TRACE
        System.setProperty("org.slf4j.simpleLogger.log.org.springframework.jdbc.core.JdbcTemplate", "debug");
        System.setProperty("org.slf4j.simpleLogger.log.org.springframework.jdbc.core"
                + ".StatementCreatorUtils", "trace");
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var jdbcTemplate = context.getBean(JdbcTemplate.class);

        String name = jdbcTemplate.queryForObject("SELECT name FROM robot WHERE id = ?", String.class, 1);
        System.out.println("id 1:    " + name);
        int updated = jdbcTemplate.update("UPDATE robot SET speed = speed + 1 WHERE speed < ?", 6);
        System.out.println("updated: " + updated);
        context.close();
    }
}
