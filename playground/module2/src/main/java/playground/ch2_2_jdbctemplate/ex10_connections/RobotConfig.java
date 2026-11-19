package playground.ch2_2_jdbctemplate.ex10_connections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class RobotConfig {

    @Bean
    public CountingDataSource dataSource() {
        return new CountingDataSource(new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .generateUniqueName(true)
                .addScript("robots-schema.sql")
                .addScript("robots-data.sql")
                .build());
    }

    @Bean
    public JdbcTemplate jdbcTemplate(CountingDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
