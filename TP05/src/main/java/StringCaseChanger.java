public class StringCaseChanger implements StringTransformer {

    public StringCaseChanger() {}

    @Override
    public void execute(StringDrink drink) {

        String text = drink.getText();
        int size = text.length();

        StringBuilder aux = new StringBuilder();

        for (int i = 0; i < size; i++) {
            char ch = text.charAt(i);

            if(Character.isLowerCase(ch)){
                aux.append(Character.toUpperCase(ch));
            }
            else {
                aux.append(Character.toLowerCase(ch));
            }
        }

        drink.setText(aux.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
