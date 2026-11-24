package playground.ch2_3_transactions.ex2_programmatic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

// Without annotations: a TransactionTemplate runs a block of code in one transaction.
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AccountConfig.class);
        TransferService service = context.getBean(TransferService.class);
        PlatformTransactionManager manager = context.getBean(PlatformTransactionManager.class);
        TransactionTemplate transactionTemplate = new TransactionTemplate(manager);

        System.out.println("before:       " + service.balances());
        try {
            transactionTemplate.executeWithoutResult(status -> service.transfer(1, 3, 20));
        } catch (RuntimeException e) {
            System.out.println("1 to 3, 20:   " + e.getMessage());
        }
        System.out.println("after:        " + service.balances());
        context.close();
    }
}
