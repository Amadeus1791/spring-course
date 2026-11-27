package labs.lab1_4.task3_profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// Logs every request in full. Never in production.
@Component
@Profile("!prod")
public class RequestLogger {
}
