package playground.ch1_1_definingbeans.ex1_empty;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext();
        context.refresh();

        var robot = new Robot("Robo");   // an object of ours, created with new

        System.out.println("Robots in the context: " + context.getBeansOfType(Robot.class).size());
        context.close();
    }
}
