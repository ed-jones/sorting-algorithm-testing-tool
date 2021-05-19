package testingtool;

import java.util.function.Function;

public class TestingTool<T> {
    Function<Int[], Function<Int, Int, Boolean>, Int[]> sortingAlgorithm;
    Function<T, T, Boolean> compare;
    Function<T> random;
    Efficiency efficiency;

    public TestingTool(Function<T[], T[]> sortingAlgorithm, Function<T, T, Boolean> compare, Function<T> random) {
        this.sortingAlgorithm = sortingAlgorithm;
        this.compare = compare;
        this.random = random;
    }

    public enum Efficiency {
        N_LOG_SQUARED_N, N_SQUARED, N_LOG_N, LOG_N, N
    }

    public enum Tests {
        PRESORTED, RANDOM, REVERSE_SORTED, NULL,
    }

    public void setEfficiency(Efficiency efficiency) {
        this.efficiency = efficiency;
    }

    public void addTest(Tests test, Int length) {
        // Code to handle adding tests
    }

    public void runTests() {
        // Code to handle running tests
    }

}
