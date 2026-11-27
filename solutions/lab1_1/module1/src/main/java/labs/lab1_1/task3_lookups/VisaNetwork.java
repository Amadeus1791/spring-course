package labs.lab1_1.task3_lookups;

import org.springframework.stereotype.Component;

@Component("cardNetwork")
public class VisaNetwork implements CardNetwork {

    @Override
    public String name() {
        return "Visa";
    }
}
