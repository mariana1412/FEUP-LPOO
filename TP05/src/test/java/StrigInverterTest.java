import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrigInverterTest {

    @Test
    public void stringInverter() {
        StringDrink drink = new StringDrink("ABCD");
        StringInverter si = new StringInverter();
        si.execute(drink);
        assertEquals("DCBA", drink.getText());
    }


}
