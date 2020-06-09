package Bar;
import String.*;

import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy{

    List<StringDrink> waitingDrinks = new ArrayList<StringDrink>();
    List<StringRecipe> waitingRecipes = new ArrayList<StringRecipe>();

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour()) bar.order(drink, recipe);
        else {
            waitingDrinks.add(drink);
            waitingRecipes.add(recipe);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for(int i = 0; i < waitingDrinks.size(); i++){
            bar.order(waitingDrinks.get(i), waitingRecipes.get(i));
        }

        waitingDrinks.clear();
        waitingRecipes.clear();
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
