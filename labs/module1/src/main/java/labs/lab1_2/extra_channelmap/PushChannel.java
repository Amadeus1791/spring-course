package labs.lab1_2.extra_channelmap;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class PushChannel implements AlertChannel {

    @Override
    public String tag() {
        return "[push] ";
    }
}
