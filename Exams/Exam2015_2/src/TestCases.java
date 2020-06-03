import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

import org.junit.*;

public class TestCases {
    // probablidade entre a média e dois desvios padrões ao lado
    private static final double prob2sigma = 0.477250;
    private static final double precision  = 5E-7;

    @Test
    public void testConstructor() throws Exception {
        NormalDistribution n = new NormalDistribution(1.0, 3.0);
        assertEquals(1.0, n.getMean(), 0.0);
        assertEquals(3.0, n.getStddev(), 0.0);
    }

    @Test
    public void testDefaultConstructor() throws Exception {
        NormalDistribution n = new NormalDistribution();
        assertEquals(0.0, n.getMean(), 0.0);
        assertEquals(1.0, n.getStddev(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvallidStddev() throws Exception {
        new NormalDistribution(0, 0);
    }

    @Test
    public void testProbabilityDistribution() throws Exception {
        ProbabilityDistribution d = new NormalDistribution(0,1);
        assertEquals(0.0, d.getMean(), 0.0);
        assertEquals(1.0, d.getStddev(), 0.0);
    }

    @Test
    public void testProbabilityDensityFunction() throws Exception {
        // See formula in http://en.wikipedia.org/wiki/Normal_distribution
        ProbabilityDistribution d = new NormalDistribution(0.0, 1.0);
        assertEquals(0.3989423, d.probabilityDensityFunction(0.0), precision);
        assertEquals(0.2419707, d.probabilityDensityFunction(1.0), precision);
        assertEquals(0.2419707, d.probabilityDensityFunction(-1.0), precision);
    }

    @Test
    public void testCalcRangeProbability() throws Exception {
        // calcRangeProbability(a,b) : probability of random variable
        // being in the interval [a, b]
        ProbabilityDistribution n = new NormalDistribution(0, 1);
        assertEquals(prob2sigma, n.calcRangeProbability(0, 2), precision);
        assertEquals(prob2sigma, n.calcRangeProbability(-2, 0), precision);
        assertEquals(2*prob2sigma, n.calcRangeProbability(-2, 2), precision);
    }

    @Test
    public void testCalcLeftProbability() throws Exception{
        // calcLeftProbability(x) : probability of random variable <= x
        ProbabilityDistribution n = new NormalDistribution(1, 1);
        assertEquals(0.5, n.calcLeftProbability(1.0), precision);
        assertEquals(0.5 + prob2sigma, n.calcLeftProbability(3.0), precision);
        assertEquals(0.5 - prob2sigma, n.calcLeftProbability(-1.0), precision);
    }

    @Test
    public void testEquals() throws Exception{
        NormalDistribution d1 = new NormalDistribution(0, 1);
        NormalDistribution d2 = new NormalDistribution(0, 1);
        assertNotSame(d1, d2);
        assertEquals(d1, d2);
    }

    @Test
    public void testAsString() throws Exception{
        NormalDistribution d1 = new NormalDistribution(2.0, 5.0);
        assertEquals("N(2.0, 5.0)", d1 + "");
    }

    @Test
    public void testFindDistribution() throws Exception{
        NormalDistribution X = new NormalDistribution("X", 2.0, 5.0);
        NormalDistribution Y = new NormalDistribution("Y", 2.0, 5.0);
        assertSame(X, ProbabilityDistribution.find("X"));
        assertNull(ProbabilityDistribution.find("Z"));
    }
}