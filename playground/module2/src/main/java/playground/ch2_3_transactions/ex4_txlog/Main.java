package playground.ch2_3_transactions.ex4_txlog;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Before the first logger exists: the transaction manager logs at DEBUG level.
        System.setProperty("org.slf4j.simpleLogger.log.org.springframework.jdbc.datasource"
                + ".DataSourceTransactionManager", "debug");
        var context = new AnnotationConfigApplicationContext(AccountConfig.class);
        TransferService service = context.getBean(TransferService.class);
        service.transfer(1, 2, 10);
        System.out.println("--- done: " + service.balances());
        context.close();
    }
}
