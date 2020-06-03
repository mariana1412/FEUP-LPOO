import javax.naming.CompositeName;
import java.util.List;

abstract class Bar {

    public List<BarObserver> observers;

    public boolean isHappyHour() {
        return true;
    };
    public void startHappyHour() {};
    public void endHappyHour() {};

    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }

}
