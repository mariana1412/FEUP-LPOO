import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Session implements Countable {

    private final ATM atm;
    private final List<Transition> transitions;

    public Session(ATM atm) {
        this.atm = atm;
        this.transitions = new ArrayList<>();
    }

    public ATM getATM() {
        return atm;
    }

    public void addTransaction(Transition transition) {
        transitions.add(transition);
    }

    @Override
    public int count() {
        return transitions.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Session)) return false;
        Session session = (Session) o;
        return Objects.equals(atm, session.atm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atm);
    }
}
