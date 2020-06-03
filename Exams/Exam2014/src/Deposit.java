public class Deposit extends Transition {

    public Deposit(ATM atm, Session session, Card card, double amount) {
        super(atm, session, card, amount);
    }
}
