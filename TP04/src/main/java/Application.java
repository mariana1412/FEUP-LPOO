public class Application {

    public static void main(String[] args) {

        AreaAggregator totalArea = new AreaAggregator();

        Shape circle = new Circle(4);
        Shape square = new Square(2);
        Shape triangle = new Triangle(5, 3);
        Shape ellipse = new Ellipse(4, 5);

        totalArea.addShape(circle);
        totalArea.addShape(square);
        totalArea.addShape(triangle);
        totalArea.addShape(ellipse);


        AreaStringOutputter stringOutputter = new AreaStringOutputter(totalArea);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(totalArea);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }


}
