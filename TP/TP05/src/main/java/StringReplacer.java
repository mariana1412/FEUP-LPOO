public class StringReplacer implements StringTransformer {

    private char toChange, replacer;

    public StringReplacer( char toChange, char replacer) {
        this.toChange = toChange;
        this.replacer = replacer;
    }


    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        drink.setText(text.replace(toChange, replacer));
    }

    @Override
    public void undo(StringDrink drink) {
        String text = drink.getText();
        drink.setText(text.replace(replacer, toChange));
    }
}
