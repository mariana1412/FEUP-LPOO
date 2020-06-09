package String;

public class StringReplacer implements StringTransformer{

    private char toReplace;
    private char toReplaceFor;
    private String beforeStringTransformer;

    public StringReplacer(char toReplace, char toReplaceFor) {
        this.toReplace = toReplace;
        this.toReplaceFor = toReplaceFor;
    }

    @Override
    public void execute(StringDrink drink) {
        beforeStringTransformer = drink.getText();
        String text = drink.getText();
        drink.setText(text.replace(toReplace, toReplaceFor));
    }

    @Override
    public void undo(StringDrink drink) {
        drink.setText(beforeStringTransformer);
    }
}
