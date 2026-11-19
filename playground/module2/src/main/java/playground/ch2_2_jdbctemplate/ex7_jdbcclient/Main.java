package playground.ch2_2_jdbctemplate.ex7_jdbcclient;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        JdbcClient jdbcClient = context.getBean(JdbcClient.class);

        int inserted = jdbcClient.sql("INSERT INTO robot (id, name, speed) VALUES (:id, :name, :speed)")
                .param("id", 3)
                .param("name", "Rita")
                .param("speed", 7)
                .update();
        System.out.println("inserted: " + inserted);

        // query(Robot.class): the columns are matched to the record components by name
        List<Robot> fast = jdbcClient.sql("SELECT id, name, speed FROM robot WHERE speed > :min ORDER BY id")
                .param("min", 4)
                .query(Robot.class)
                .list();
        System.out.println("fast:     " + fast);
        context.close();
    }
}
