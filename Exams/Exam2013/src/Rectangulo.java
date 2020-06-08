import static java.lang.Math.abs;

public class Rectangulo extends Figura {

    private int x1, y1, x2, y2;

    public Rectangulo(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        inc();
    }

    @Override
    public double getArea() {
        return abs(x2-x1)*abs(y2-y1);
    }

    @Override
    public double getPerimetro() {
        return 2*abs(x2-x1) + 2*abs(y2-y1);
    }
}
