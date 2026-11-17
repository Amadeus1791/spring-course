package labs.lab1_1.task4_scan;

import labs.lab1_1.task4_scan.config.CardConfig;
import labs.lab1_1.task4_scan.masking.CardNumberMasker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.1, task 4. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            CardNumberMasker masker = context.getBean(CardNumberMasker.class);
            System.out.println("Receipt: VISA " + masker.mask("4000123412341234"));
        }
    }
}
