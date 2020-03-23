public class StringInverter implements StringTransformer {


    @Override
    public void execute(StringDrink text) {
        StringBuffer aux = new StringBuffer(text.getText());
        aux.reverse();
        text.setText(aux.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
