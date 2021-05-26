package testingtool;

import helpers.FuncInterface;

import java.util.ArrayList;
import java.util.List;
import algorithms.interfaces.ISort;

public class TestingTool<T> {
    ISort<T> sortingAlgorithm;
    FuncInterface<T> ICompare;
    List<T> randomList;
    Efficiency efficiency;
    List<Test> tests;
    
    public TestingTool(ISort<T> sortingAlgorithm,
            FuncInterface<T> ICompare, List<T> randomList) {
        this.sortingAlgorithm = sortingAlgorithm;
        this.ICompare = ICompare;
        this.randomList = randomList;
        tests = new ArrayList<Test>();
    }

    public enum Efficiency {
        N_LOG_SQUARED_N, N_SQUARED, N_LOG_N, LOG_N, N
    }

    public enum TestType {
        PRESORTED, RANDOM, REVERSE_SORTED, NULL,
    }

    public void setEfficiency(Efficiency efficiency) {
        this.efficiency = efficiency;
    }

    public void addTest(TestType typeOfTest) {
        // Code to handle adding tests
        tests.add(new Test<T>(ICompare, sortingAlgorithm, typeOfTest, randomList));
    }

    public void runTests() {
        // Code to handle running tests
        for(Test<T> t : tests) {
            t.run();
        }
    }

}
