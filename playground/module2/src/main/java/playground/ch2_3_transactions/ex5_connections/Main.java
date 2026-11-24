package playground.ch2_3_transactions.ex5_connections;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AccountConfig.class);
        TransferService service = context.getBean(TransferService.class);
        CountingDataSource dataSource = context.getBean(CountingDataSource.class);

        int before = dataSource.connections();
        service.transferWithoutTransaction(1, 2, 1);
        System.out.println("without @Transactional, connections: " + (dataSource.connections() - before));

        before = dataSource.connections();
        service.transfer(1, 2, 1);
        System.out.println("with @Transactional, connections:    " + (dataSource.connections() - before));
        context.close();
    }
}
