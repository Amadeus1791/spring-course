package labs.lab2_2.task3_figures;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 2.2, task 3. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardDataConfig.class)) {
            CardReport report = context.getBean(CardReport.class);
            System.out.println("total limit:     " + report.totalLimit());
            System.out.println("cards above 900: " + report.cardsAbove(900));
            System.out.println("limit by holder: " + report.limitByHolder());
        }
    }
}
