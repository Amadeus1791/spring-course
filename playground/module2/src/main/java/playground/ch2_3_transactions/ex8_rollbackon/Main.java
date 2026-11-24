package playground.ch2_3_transactions.ex8_rollbackon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- DefaultConfig");
        run(DefaultConfig.class);
        System.out.println("--- AllConfig");
        run(AllConfig.class);
    }

    private static void run(Class<?> config) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(config);
        TransferService service = context.getBean(TransferService.class);
        System.out.println("before:     " + service.balances());
        try {
            service.transfer(2, 1, 80);
        } catch (InsufficientFundsException e) {
            System.out.println("2 to 1, 80: " + e.getClass().getSimpleName());
        }
        System.out.println("after:      " + service.balances());
        context.close();
    }
}
