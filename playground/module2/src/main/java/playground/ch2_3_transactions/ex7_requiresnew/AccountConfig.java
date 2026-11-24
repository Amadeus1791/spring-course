package playground.ch2_3_transactions.ex7_requiresnew;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class AccountConfig {

    // A pool of the size Main passes in, and a short wait for a free connection.
    @Bean
    public HikariDataSource dataSource(@Value("${pool.size}") int poolSize) {
        var pool = new HikariDataSource();
        pool.setJdbcUrl("jdbc:h2:mem:accounts-" + poolSize);
        pool.setPoolName("accounts-pool");
        pool.setMaximumPoolSize(poolSize);
        pool.setConnectionTimeout(500);     // milliseconds, the default is 30 seconds
        new ResourceDatabasePopulator(new ClassPathResource("account-schema.sql"),
                new ClassPathResource("account-data.sql"), new ClassPathResource("note-schema.sql"))
                .execute(pool);
        return pool;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(HikariDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(HikariDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
