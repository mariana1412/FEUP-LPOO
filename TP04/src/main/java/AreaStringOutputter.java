public class AreaStringOutputter {

    private AreaAggregator area;

    public AreaStringOutputter(AreaAggregator area) {
        this.area = area;
    }

    public String output(){
        return "Sum of areas: " + area.sum();
    }

}
