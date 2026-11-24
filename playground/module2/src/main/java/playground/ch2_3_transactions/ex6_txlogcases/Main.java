package playground.ch2_3_transactions.ex6_txlogcases;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Before the first logger exists: the transaction manager logs at DEBUG level.
        System.setProperty("org.slf4j.simpleLogger.log.org.springframework.jdbc.datasource"
                + ".DataSourceTransactionManager", "debug");
        var context = new AnnotationConfigApplicationContext(AccountConfig.class);
        TransferBatch batch = context.getBean(TransferBatch.class);

        System.out.println("--- case 1: twoTransfers()");
        batch.twoTransfers();
        System.out.println("--- case 2: transferWithNote()");
        batch.transferWithNote();
        System.out.println("--- case 3: catchClosed()");
        try {
            batch.catchClosed();
        } catch (RuntimeException e) {
            System.out.println("catchClosed() threw: " + e.getClass().getSimpleName());
        }
        System.out.println("--- done: " + context.getBean(TransferService.class).balances());
        context.close();
    }
}
