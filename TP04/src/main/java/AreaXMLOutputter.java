public class AreaXMLOutputter {

    private AreaAggregator area;

    public AreaXMLOutputter(AreaAggregator area) {

        this.area = area;
    }

    public String output(){
        return "<area>" + area.sum() + "</area>";
    }

}
