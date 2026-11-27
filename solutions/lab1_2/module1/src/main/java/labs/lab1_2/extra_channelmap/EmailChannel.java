package labs.lab1_2.extra_channelmap;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class EmailChannel implements AlertChannel {

    @Override
    public String tag() {
        return "[email]";
    }
}
