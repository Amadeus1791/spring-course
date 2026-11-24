package playground.ch2_3_transactions.ex5_connections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class AccountConfig {

    @Bean
    public CountingDataSource dataSource() {
        return new CountingDataSource(new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .generateUniqueName(true)
                .addScript("account-schema.sql")
                .addScript("account-data.sql")
                .build());
    }

    @Bean
    public JdbcTemplate jdbcTemplate(CountingDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    // The transaction manager for one DataSource: it begins, commits and rolls back on its connection.
    @Bean
    public PlatformTransactionManager transactionManager(CountingDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
