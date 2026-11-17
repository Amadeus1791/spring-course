package playground.ch1_3_scopeslifecycle.ex9_bpp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        context.close();
    }
}
