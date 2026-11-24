package playground.ch2_3_transactions.ex4c_options;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var context = new AnnotationConfigApplicationContext(AccountConfig.class);
        var service = context.getBean(AccountService.class);
        System.out.println("find() read-only: " + service.find());
        System.out.println("save() read-only: " + service.save());
        System.out.println("drain() rows:      " + service.drain() + ", then " + service.balances());
        try {
            service.slowDrain();
        } catch (RuntimeException e) {
            System.out.println("slowDrain():       " + e.getClass().getSimpleName());
        }
        System.out.println("after:             " + service.balances());
        context.close();
    }
}
