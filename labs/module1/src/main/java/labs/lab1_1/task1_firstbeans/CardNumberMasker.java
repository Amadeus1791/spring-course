package labs.lab1_1.task1_firstbeans;

// Shows only the last four digits of a card number, as on a receipt.
public class CardNumberMasker {

    public String mask(String cardNumber) {
        String lastFour = cardNumber.substring(cardNumber.length() - 4);
        return "**** **** **** " + lastFour;
    }
}
