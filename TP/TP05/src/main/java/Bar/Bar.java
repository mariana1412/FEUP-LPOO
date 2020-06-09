package Bar;

import java.util.ArrayList;
import java.util.List;
import String.*;

public abstract class Bar {

    private final List<BarObserver> observers;
    private boolean happyHour;

    public Bar() {
        this.happyHour = false;
        this.observers = new ArrayList<BarObserver>();
    }

    public boolean isHappyHour(){
        return happyHour;
    }

    public void startHappyHour(){
        this.happyHour = true;
        notifyObservers();
    }

    public void endHappyHour(){
        this.happyHour = false;
        notifyObservers();
    }

    public abstract void order(StringDrink drink, StringRecipe recipe);

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
