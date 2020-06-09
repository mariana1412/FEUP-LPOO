package String;

public class StringCaseChanger implements StringTransformer{

    private String beforeStringTransformer;

    @Override
    public void execute(StringDrink drink) {
        beforeStringTransformer = drink.getText();

        StringBuilder text = new StringBuilder();
        text.append(drink.getText());

        for (int i=0; i<text.length(); i++)
        {
            Character c = text.charAt(i);
            if (Character.isLowerCase(c))
                text.replace(i, i+1, String.valueOf(Character.toUpperCase(c)));
            else
                text.replace(i, i+1, String.valueOf(Character.toLowerCase(c)));

        }

        drink.setText(text.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        drink.setText(beforeStringTransformer);
    }
}
