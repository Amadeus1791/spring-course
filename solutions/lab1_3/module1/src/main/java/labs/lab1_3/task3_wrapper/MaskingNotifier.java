package labs.lab1_3.task3_wrapper;

// Wraps a notifier: masks every 16-digit card number before the message leaves the bank.
public class MaskingNotifier implements CardNotifier {

    private final CardNotifier target;

    public MaskingNotifier(CardNotifier target) {
        this.target = target;
    }

    @Override
    public void send(String message) {
        String masked = message.replaceAll("\\d{12}(\\d{4})", "**** **** **** $1");
        target.send(masked);
    }
}
