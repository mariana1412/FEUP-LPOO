public abstract class Transition {

    private final ATM atm;
    private final Card card;
    private final Session session;
    private double amount;

    public Transition(ATM atm, Session session, Card card, double amount) {
        this.atm = atm;
        this.card = card;
        this.session = session;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ATM getAtm() {
        return atm;
    }


}
