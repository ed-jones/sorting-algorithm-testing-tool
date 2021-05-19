package testingtool;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class TestingTool<T> {
    BiFunction<T[], BiFunction<T, T, Boolean>, T[]> sortingAlgorithm;
    BiFunction<T, T, Boolean> compare;
    Supplier<T> random;
    Efficiency efficiency;

    public TestingTool(BiFunction<T[], BiFunction<T, T, Boolean>, T[]> sortingAlgorithm,
            BiFunction<T, T, Boolean> compare, Supplier<T> random) {
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

    public void addTest(Tests test, Integer length) {
        // Code to handle adding tests
    }

    public void runTests() {
        // Code to handle running tests
    }

}