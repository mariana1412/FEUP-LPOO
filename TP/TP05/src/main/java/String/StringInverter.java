package String;

public class StringInverter implements StringTransformer{

    private String beforeStringTransformer;

    public void execute(StringDrink drink) {
        beforeStringTransformer = drink.getText();
        StringBuilder text = new StringBuilder();
        text.append(drink.getText());
        text = text.reverse();
        drink.setText(text.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        drink.setText(beforeStringTransformer);
    }
}
