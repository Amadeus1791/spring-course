package labs.lab1_4.task1_values;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.4, task 1. Predict A to D first, then run.
public class Main {

    public static void main(String[] args) {
        System.setProperty("card.region", "US");
        run("A", Cases.CaseA.class);
        System.clearProperty("card.region");
        run("B", Cases.CaseB.class);
        run("C", Cases.CaseC.class);
        run("D", Cases.CaseD.class);
    }

    // Prints the value the bean received, or the innermost cause of the failed start.
    private static void run(String label, Class<?> config) {
        try (var context = new AnnotationConfigApplicationContext(config)) {
            System.out.println(label + "  " + context.getBean(Setting.class).value());
        } catch (RuntimeException e) {
            Throwable root = e;
            while (root.getCause() != null) {
                root = root.getCause();
            }
            System.out.println(label + "  " + root.getClass().getSimpleName());
            System.out.println("   " + root.getMessage());
        }
    }
}
