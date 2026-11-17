package labs.lab1_4.compliance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// The configuration of the compliance team, used by lab 1.4, task 3. Do not change this class.
@Configuration
@Profile("prod")
public class ComplianceConfig {

    @Bean
    public AuditTrail auditTrail() {
        return new AuditTrail();
    }
}
