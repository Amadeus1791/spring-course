package labs.lab1_4.task4_typo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.4, task 4. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            System.out.println(context.getBean(StatementFooter.class).text());
        }
    }
}
