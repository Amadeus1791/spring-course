package playground.ch2_2_jdbctemplate.ex2b_hikari;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var dataSource = (HikariDataSource) context.getBean(DataSource.class);
        var jdbcTemplate = context.getBean(JdbcTemplate.class);
        System.out.println("data source: " + dataSource.getClass().getSimpleName());
        System.out.println("url:         " + dataSource.getJdbcUrl());
        System.out.println("pool size:   " + dataSource.getMaximumPoolSize());
        System.out.println("robots:      " + jdbcTemplate.queryForList("SELECT name FROM robot ORDER BY id", String.class));
        context.close();
        System.out.println("closed:      " + dataSource.isClosed());
    }
}
