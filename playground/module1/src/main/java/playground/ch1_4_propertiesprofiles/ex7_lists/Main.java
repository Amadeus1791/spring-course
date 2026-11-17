package playground.ch1_4_propertiesprofiles.ex7_lists;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. RobotConfig:");
        print(new AnnotationConfigApplicationContext(RobotConfig.class));
        System.out.println("2. ConversionConfig:");
        print(new AnnotationConfigApplicationContext(ConversionConfig.class));
    }

    private static void print(AnnotationConfigApplicationContext context) {
        var robot = context.getBean(Robot.class);
        System.out.println("  String[]:         " + robot.getToolArray().length + " " + Arrays.toString(robot.getToolArray()));
        System.out.println("  List<String>:     " + robot.getToolList().size() + " " + robot.getToolList());
        System.out.println("  List, SpEL split: " + robot.getSplitList().size() + " " + robot.getSplitList());
        context.close();
    }
}
