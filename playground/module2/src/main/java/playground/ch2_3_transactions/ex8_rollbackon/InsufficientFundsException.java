package playground.ch2_3_transactions.ex8_rollbackon;

// A checked exception, like a bank's InsufficientFundsException.
public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}
