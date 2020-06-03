public class Withdrawal extends Transition {


    public Withdrawal(ATM atm, Session session, Card card, double amount) {
        super(atm, session, card, amount);
    }

    @Override
    public String toString() {
        return "Withdrawal at " + getAtm() + " of " + String.format("%.2f", getAmount()).replace(',', '.');
    }
}
