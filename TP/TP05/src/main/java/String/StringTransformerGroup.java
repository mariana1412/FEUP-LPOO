package String;

import javax.xml.transform.Transformer;
import java.util.List;

public class StringTransformerGroup implements StringTransformer{

    private List<StringTransformer> transformers;
    private String beforeStringTransformer;

    public StringTransformerGroup(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    @Override
    public void execute(StringDrink drink) {
        beforeStringTransformer = drink.getText();
        for(StringTransformer transformer : transformers) transformer.execute(drink);
    }

    @Override
    public void undo(StringDrink drink) {
        drink.setText(beforeStringTransformer);
    }
}
