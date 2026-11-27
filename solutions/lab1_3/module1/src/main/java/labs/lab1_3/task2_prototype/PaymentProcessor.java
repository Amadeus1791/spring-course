package labs.lab1_3.task2_prototype;

import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

// Processes card payments. One processor for the whole application,
// one new Authorization per payment: the provider asks the context every time.
@Service
public class PaymentProcessor {

    private final ObjectProvider<Authorization> authorizations;

    public PaymentProcessor(ObjectProvider<Authorization> authorizations) {
        this.authorizations = authorizations;
    }

    public List<String> process(String card, int amount) {
        Authorization authorization = authorizations.getObject();
        authorization.step("check card " + card);
        authorization.step("approve " + amount + " EUR");
        return authorization.steps();
    }
}
