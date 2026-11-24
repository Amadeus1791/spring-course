package playground.ch2_3_transactions.ex4a_propagation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Four sections, each example with a fresh database: Anna 100, Ben 50, Carl 0 (account 3 is closed).
public class Main {

    public static void main(String[] args) {
        System.out.println("--- 1 REQUIRED");
        try (var context = new AnnotationConfigApplicationContext(AccountConfig.class)) {
            TransferService transfers = context.getBean(TransferService.class);
            try {
                transfers.transfer(1, 3, 20);
            } catch (IllegalArgumentException e) {
                System.out.println("transfer:     " + e.getMessage());
            }
            System.out.println("accounts:     " + transfers.balances());
            System.out.println("journal:      " + context.getBean(Journal.class).lines());
        }

        System.out.println("--- 2 REQUIRES_NEW");
        try (var context = new AnnotationConfigApplicationContext(AccountConfig.class)) {
            TransferService transfers = context.getBean(TransferService.class);
            try {
                transfers.transferNew(1, 3, 20);
            } catch (IllegalArgumentException e) {
                System.out.println("transferNew:  " + e.getMessage());
            }
            System.out.println("accounts:     " + transfers.balances());
            System.out.println("journal:      " + context.getBean(Journal.class).lines());
        }

        System.out.println("--- 3 MANDATORY");
        try (var context = new AnnotationConfigApplicationContext(AccountConfig.class)) {
            TransferService transfers = context.getBean(TransferService.class);
            Journal journal = context.getBean(Journal.class);
            try {
                journal.writeMandatory("from main");                   // no transaction running
            } catch (RuntimeException e) {
                System.out.println("from main:    " + e.getClass().getSimpleName());
                System.out.println("              " + e.getMessage());
            }
            transfers.transferMandatory(1, 2, 10);                     // inside a transfer
            try {
                transfers.transferMandatory(1, 3, 20);                 // inside a failing transfer
            } catch (IllegalArgumentException e) {
                System.out.println("1 to 3, 20:   " + e.getMessage());
            }
            System.out.println("accounts:     " + transfers.balances());
            System.out.println("journal:      " + journal.lines());
        }

        // Each of the three: once from main, then inside a transfer to Carl's closed account.
        System.out.println("--- 4 SUPPORTS, NOT_SUPPORTED, NEVER");
        try (var context = new AnnotationConfigApplicationContext(AccountConfig.class)) {
            TransferService transfers = context.getBean(TransferService.class);
            Journal journal = context.getBean(Journal.class);
            journal.writeSupports("from main");
            try {
                transfers.transferSupports(1, 3, 20);
            } catch (RuntimeException e) {
                System.out.println("SUPPORTS        transfer: " + e.getMessage());
            }
            System.out.println("                journal:  " + journal.lines());
        }
        try (var context = new AnnotationConfigApplicationContext(AccountConfig.class)) {
            TransferService transfers = context.getBean(TransferService.class);
            Journal journal = context.getBean(Journal.class);
            journal.writeNotSupported("from main");
            try {
                transfers.transferNotSupported(1, 3, 20);
            } catch (RuntimeException e) {
                System.out.println("NOT_SUPPORTED   transfer: " + e.getMessage());
            }
            System.out.println("                journal:  " + journal.lines());
        }
        try (var context = new AnnotationConfigApplicationContext(AccountConfig.class)) {
            TransferService transfers = context.getBean(TransferService.class);
            Journal journal = context.getBean(Journal.class);
            journal.writeNever("from main");
            try {
                transfers.transferNever(1, 3, 20);
            } catch (RuntimeException e) {
                System.out.println("NEVER           transfer: " + e.getClass().getSimpleName());
            }
            System.out.println("                journal:  " + journal.lines());
            System.out.println("                accounts: " + transfers.balances());
        }
    }
}
