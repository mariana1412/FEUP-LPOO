import java.util.ArrayList;

public class StringBar extends Bar {

    private boolean happyHour;

    public StringBar() {
        this.happyHour = false;
        this.observers = new ArrayList<>();
    }

    @Override
    public boolean isHappyHour() {
        return happyHour;
    }

    @Override
    public void startHappyHour() {
        happyHour = true;
        notifyObservers();
    }

    @Override
    public void endHappyHour() {
        happyHour = false;
        notifyObservers();
    }

    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }
}
