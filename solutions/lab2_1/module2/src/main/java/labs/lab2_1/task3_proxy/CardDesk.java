package labs.lab2_1.task3_proxy;

import org.springframework.stereotype.Component;

// The desk in the branch. No interface.
@Component
public class CardDesk {

    // serve() calls check() on the same object.
    public String serve(String customer) {
        check(customer);
        return "served " + customer;
    }

    public void check(String customer) {
    }

    public final String sign() {
        return "signed";
    }
}
