import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.Random;

public class Monster extends Element {

    public Monster(int x, int y) {
        super(x, y); //super calls the parent class' constructor with the arguments passed to it
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#3f2a14"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }

    public Position move(){
        Random random = new Random();
        int dir = random.nextInt(4)+1;

        switch (dir){
            case 1: //up
                return (new Position(getPosition().getX(), getPosition().getY()-1));

            case 2: //left
                return (new Position(getPosition().getX()-1, getPosition().getY()));

            case 3: //down
                return (new Position(getPosition().getX(), getPosition().getY()+1));

            case 4: //right
                return (new Position(getPosition().getX()+1, getPosition().getY()));
        }

        return new Position(0,0);
    }

}
