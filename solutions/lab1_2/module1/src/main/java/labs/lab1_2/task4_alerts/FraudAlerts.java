package labs.lab1_2.task4_alerts;

import java.util.List;
import org.springframework.stereotype.Service;

// Sends a fraud alert to the customer, on every channel the context knows.
@Service
public class FraudAlerts {

    private final List<AlertChannel> channels;

    public FraudAlerts(List<AlertChannel> channels) {
        this.channels = channels;
    }

    public void alert(String message) {
        for (AlertChannel channel : channels) {
            channel.send(message);
        }
    }

    public int channels() {
        return channels.size();
    }
}
