package playground.ch2_2_jdbctemplate.ex2_datasource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println("data source: " + dataSource.getClass().getSimpleName());
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("database:    " + connection.getMetaData().getDatabaseProductName()
                    + " " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("url:         " + connection.getMetaData().getURL());
        }
        context.close();
    }
}
