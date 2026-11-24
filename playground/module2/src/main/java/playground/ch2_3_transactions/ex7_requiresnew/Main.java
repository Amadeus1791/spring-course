package playground.ch2_3_transactions.ex7_requiresnew;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

    public static void main(String[] args) {
        run(2);
        run(1);
    }

    private static void run(int poolSize) {
        System.out.println("--- pool size " + poolSize);
        System.setProperty("pool.size", String.valueOf(poolSize));
        var context = new AnnotationConfigApplicationContext(AccountConfig.class);
        try {
            context.getBean(TransferBatch.class).transferWithNote();
            System.out.println("transferWithNote() done");
        } catch (RuntimeException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            System.out.println("cause: " + e.getCause().getClass().getSimpleName() + ": " + e.getCause().getMessage());
        }
        System.out.println("balances: " + context.getBean(JdbcTemplate.class)
                .queryForList("SELECT owner || ' ' || balance FROM account ORDER BY id", String.class));
        context.close();
    }
}
