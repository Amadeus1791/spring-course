package labs.lab1_2.task2_whowins;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.2, task 2. Predict A to D first, then run.
public class Main {

    public static void main(String[] args) {
        run("A", Cases.CaseA.class);
        run("B", Cases.CaseB.class);
        run("C", Cases.CaseC.class);
        run("D", Cases.CaseD.class);
    }

    // Prints the name of the screen the gate got, or the innermost cause of the failed start.
    private static void run(String label, Class<?> config) {
        try (var context = new AnnotationConfigApplicationContext(config)) {
            System.out.println(label + "  " + context.getBean(PaymentGate.class).screen().name());
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
