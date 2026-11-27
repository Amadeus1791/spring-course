package labs.lab2_1.task3_proxy;

import org.springframework.stereotype.Component;

// Issues plastic cards. Implements an interface: what does the proxy look like?
@Component
public class PlasticCardIssuer implements CardIssuer {

    @Override
    public String issue(String customer) {
        return "card for " + customer;
    }
}
