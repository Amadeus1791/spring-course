package labs.lab1_4.task3_profiles;

import labs.lab1_4.compliance.ComplianceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import(ComplianceConfig.class)
public class CardConfig {
}
