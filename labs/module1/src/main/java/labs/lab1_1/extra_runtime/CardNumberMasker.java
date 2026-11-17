package labs.lab1_1.extra_runtime;

// Shows only the last four digits of a card number, as on a receipt.
public class CardNumberMasker {

    public String mask(String cardNumber) {
        String lastFour = cardNumber.substring(cardNumber.length() - 4);
        return "**** **** **** " + lastFour;
    }
}
