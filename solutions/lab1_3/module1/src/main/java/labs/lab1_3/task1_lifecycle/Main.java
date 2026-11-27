package labs.lab1_3.task1_lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.3, task 1. Predict first, then run.
public class Main {

    public static void main(String[] args) {
        System.out.println("1. start");
        var context = new AnnotationConfigApplicationContext(TerminalConfig.class);
        System.out.println("2. a payment");
        context.getBean(Receipt.class);
        System.out.println("3. the evening");
        context.getBean(DailyArchive.class);
        System.out.println("4. close");
        context.close();
        System.out.println("5. closed");
    }
}
