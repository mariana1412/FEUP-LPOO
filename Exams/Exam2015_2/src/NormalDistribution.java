public class NormalDistribution extends ProbabilityDistribution{

    private String name;

    public NormalDistribution() {
        super();
    }

    public NormalDistribution(double mean, double stddev) throws IllegalArgumentException {
        super(mean, stddev);
    }

    public NormalDistribution(String name, double mean, double stddev) throws IllegalArgumentException {
        super(mean, stddev);
        this.name = name;
        super.addNormalDistribution(this);
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "N(" + getMean() + ", " + getStddev() + ')';
    }
}
