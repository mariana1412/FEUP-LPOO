import java.util.Objects;

public class ATM {

    private final int ID;
    private final String city;
    private final String bank;

    public ATM(int id, String city, String bank) {
        this.ID = id;
        this.city = city;
        this.bank = bank;
    }

    public int getID() {
        return ID;
    }


    @Override
    public String toString() {
        return "ATM " + ID +
                " (" + city +
                ", " + bank + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ATM)) return false;
        ATM atm = (ATM) o;
        return ID == atm.ID &&
                Objects.equals(city, atm.city) &&
                Objects.equals(bank, atm.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, city, bank);
    }
}
