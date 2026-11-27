package labs.lab1_1.task2_names;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.1, task 2. Predict A to E first, then run.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            System.out.println("A  containsBean(\"platinumLimits\"): "
                    + context.containsBean("platinumLimits"));
            System.out.println("B  name of the PANMasker:          "
                    + context.getBeanNamesForType(PANMasker.class)[0]);
            System.out.println("C  name of the CvvCheck:           "
                    + context.getBeanNamesForType(CvvCheck.class)[0]);
            System.out.println("D  name of the VisaNetwork:        "
                    + context.getBeanNamesForType(VisaNetwork.class)[0]);
            System.out.println("E  all LimitTable beans:           "
                    + Arrays.toString(context.getBeanNamesForType(LimitTable.class)));
        }
    }
}
