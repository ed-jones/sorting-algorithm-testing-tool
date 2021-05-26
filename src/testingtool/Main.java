package testingtool;

import helpers.FuncInterface;

import java.util.function.Supplier;
import java.util.List;
import java.util.Random;

import algorithms.BubbleSort;
import algorithms.interfaces.ISort;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        FuncInterface<Integer> compare = (a, b) -> a < b;

        // Define the sorting algorithm to use
        ISort<Integer> sortingAlgorithm = new BubbleSort<Integer>();

        // Generate List
        RandomList<Integer> randomList = new RandomList<>();
        List<Integer> list = randomList.generateList(rand -> rand.nextInt(10), 5);

        TestingTool<Integer> testingTool = new TestingTool<Integer>(sortingAlgorithm, compare, list);
        testingTool.setEfficiency(TestingTool.Efficiency.N);
        testingTool.addTest(TestingTool.TestType.PRESORTED);

    }
}
