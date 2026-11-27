package labs.lab2_1.task4_pointcuts.service;

public class CardService {

    public String pay(int amount) {
        return "paid " + amount;
    }

    public String refund(int amount) {
        return "refunded " + amount;
    }
}
