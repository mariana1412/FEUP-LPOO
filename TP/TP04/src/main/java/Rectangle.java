public class Rectangle implements AreaShape, Drawable{
    private double height,  width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea(){
        return height * width;
    }

    @Override
    public void draw() {

        System.out.println("Rectangle");;
    }

}
