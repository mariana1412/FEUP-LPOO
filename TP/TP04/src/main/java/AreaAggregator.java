import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider{

    private List<HasArea> shapes = new ArrayList<>();

    public void addShape(HasArea area) {
        shapes.add(area);
    }

    public double sum() {
        double sum = 0;
        for (HasArea area : shapes) {
            sum += area.getArea();
        }
        return sum;
    }


}
