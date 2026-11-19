package playground.ch2_2_jdbctemplate.ex2b_hikari;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class RobotConfig {

    // A pool as the DataSource. The URL decides the database: here H2 in memory,
    // in production for example jdbc:postgresql://db.bank.local:5432/bank (and its driver in the pom).
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:h2:mem:robots");
        dataSource.setUsername("sa");
        dataSource.setMaximumPoolSize(5);
        return dataSource;   // closed with the context: Spring finds its close() method
    }

    // The builder ran the scripts for us. With a pool, an initializer runs them at start.
    @Bean
    public DataSourceInitializer initializer(DataSource dataSource) {
        var scripts = new ResourceDatabasePopulator(
                new ClassPathResource("robots-schema.sql"), new ClassPathResource("robots-data.sql"));
        var initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(scripts);
        return initializer;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
