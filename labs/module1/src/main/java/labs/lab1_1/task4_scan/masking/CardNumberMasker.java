package labs.lab1_1.task4_scan.masking;

import org.springframework.stereotype.Component;

// Shows only the last four digits of a card number, as on a receipt.
@Component
public class CardNumberMasker {

    public String mask(String cardNumber) {
        String lastFour = cardNumber.substring(cardNumber.length() - 4);
        return "**** **** **** " + lastFour;
    }
}
