package labs.lab1_4.extra_lists;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// The card networks the bank accepts, read twice from the same key.
@Component
public class Networks {

    private final List<String> asList;
    private final String[] asArray;

    public Networks(@Value("${card.networks}") List<String> asList,
                    @Value("${card.networks}") String[] asArray) {
        this.asList = asList;
        this.asArray = asArray;
    }

    public List<String> asList() {
        return asList;
    }

    public String[] asArray() {
        return asArray;
    }
}
