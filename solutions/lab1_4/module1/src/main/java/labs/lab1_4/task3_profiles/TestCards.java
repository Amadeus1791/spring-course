package labs.lab1_4.task3_profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// A few cards to play with.
@Component
@Profile({"default", "dev"})
public class TestCards {
}
