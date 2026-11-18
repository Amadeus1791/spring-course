package playground.ch1_4_propertiesprofiles.ex11_environment;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Robot {

    private final String name;

    public Robot(Environment env) {             // a bean asks for the Environment like for any bean
        this.name = env.getProperty("robot.name");
    }

    public String getName() {
        return name;
    }
}
