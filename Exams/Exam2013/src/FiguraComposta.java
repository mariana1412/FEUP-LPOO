public class FiguraComposta extends Figura {

    private Figura[] figuras;

    public FiguraComposta(Figura[] figuras) {
        this.figuras = figuras;
        for(Figura figura : figuras){
            inc();
        }
    }

    @Override
    public double getArea() {
        double area = 0;
        for(Figura figura : figuras){
            area += figura.getArea();
        }
        return area;
    }

    @Override
    public double getPerimetro() {
        double perimetro = 0;
        for(Figura figura : figuras){
            perimetro += figura.getPerimetro();
        }
        return perimetro;
    }
}
