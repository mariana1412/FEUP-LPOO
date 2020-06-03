import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ProbabilityDistribution {

    private double mean;
    private double stddev;
    private static List<NormalDistribution> probabilities;

    public ProbabilityDistribution() {
        this.mean = 0.0;
        this.stddev = 1.0;
        this.probabilities = new ArrayList<>();
    }

    public ProbabilityDistribution(double mean, double stddev) throws IllegalArgumentException {
        if(stddev == 0.0 && stddev == 0.0) throw new IllegalArgumentException();
        this.mean = mean;
        this.stddev = stddev;
        this.probabilities = new ArrayList<>();
    }


    public double getMean() {
        return mean;
    }

    public double getStddev() {
        return stddev;
    }

    public double probabilityDensityFunction(double v) {
        //https://en.wikipedia.org/wiki/Normal_distribution
        double res, first, second, third;

        first = 1 / Math.sqrt(2 * Math.PI * Math.pow(this.stddev, 2));
        second = -Math.pow((v - this.mean), 2) / (2 * Math.pow(this.stddev, 2));
        third = Math.pow(Math.E, second);
        res = first * third;

        return res;
    }

    public double calcRangeProbability(int a, int b) {
        double prob2sigma = 0.477250;
        double result = Math.abs(b-a)/2*prob2sigma;
        return result;
    }

    public double calcLeftProbability(double v) {
        double prob2sigma = 0.477250;
        double result = 0.5;

        if(v < 1.0) result -= prob2sigma;
        else if (v > 1.0) result += prob2sigma;

        return result;
    }

    public void addNormalDistribution(NormalDistribution dist){
        probabilities.add(dist);
    }

    public static NormalDistribution find(String name) {
        for (NormalDistribution normal : probabilities){
            if(normal.getName().equals(name))
                return normal;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProbabilityDistribution)) return false;
        ProbabilityDistribution that = (ProbabilityDistribution) o;
        return Double.compare(that.mean, mean) == 0 &&
                Double.compare(that.stddev, stddev) == 0;
    }


}
