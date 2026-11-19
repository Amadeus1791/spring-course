package labs.lab1_3.task1_lifecycle;

import jakarta.annotation.PreDestroy;

// One receipt per payment.
public class Receipt {

    public Receipt() {
        System.out.println("  receipt printed");
    }

    @PreDestroy
    public void shred() {
        System.out.println("  receipt shredded");
    }
}
