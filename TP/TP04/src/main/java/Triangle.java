public class Triangle implements AreaShape, Drawable{
    private double height, base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public double getArea(){
        return height * base / 2;
    }

    @Override
    public void draw() {
        System.out.println("Triangle");
    }

}
