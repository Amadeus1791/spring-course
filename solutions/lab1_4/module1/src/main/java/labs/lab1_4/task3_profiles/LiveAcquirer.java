package labs.lab1_4.task3_profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// Talks to the real card acquirer.
@Component
@Profile("prod")
public class LiveAcquirer {
}
