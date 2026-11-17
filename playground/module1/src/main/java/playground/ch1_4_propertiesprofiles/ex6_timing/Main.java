package playground.ch1_4_propertiesprofiles.ex6_timing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // 1. Properties: @PropertySource is read during refresh
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(RobotConfig.class);
        System.out.println("robot.name before refresh: " + context.getEnvironment().getProperty("robot.name"));
        context.refresh();
        System.out.println("robot.name after refresh:  " + context.getEnvironment().getProperty("robot.name"));
        context.close();

        // 2. Profiles: the constructor with a class already calls refresh
        AnnotationConfigApplicationContext started = new AnnotationConfigApplicationContext(RobotConfig.class);
        started.getEnvironment().setActiveProfiles("home");
        System.out.println("profile set after refresh, homeRobot exists: " + started.containsBean("homeRobot"));
        started.close();
    }
}
