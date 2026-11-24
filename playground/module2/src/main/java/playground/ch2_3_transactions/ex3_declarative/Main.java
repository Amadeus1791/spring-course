package playground.ch2_3_transactions.ex3_declarative;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AccountConfig.class);
        TransferService service = context.getBean(TransferService.class);

        System.out.println("before:       " + service.balances());
        service.transfer(1, 2, 10);
        System.out.println("1 to 2, 10:   " + service.balances());
        try {
            service.transfer(1, 3, 20);    // Carl's account is closed
        } catch (RuntimeException e) {
            System.out.println("1 to 3, 20:   " + e.getMessage());
        }
        System.out.println("after:        " + service.balances());
        System.out.println("class:        " + service.getClass().getSimpleName());
        context.close();
    }
}
