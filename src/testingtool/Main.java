package testingtool;

import helpers.FuncInterface;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        FuncInterface<Integer> compare = (a, b) -> a < b;
        BiFunction<Integer[], BiFunction<Integer, Integer, Boolean>, Integer[]> sortingAlgorithm = (input,
                compareFunction) -> input;
        Supplier<Integer> generateRandom = () -> {
            var random = new Random();
            random.setSeed(100);
            return random.nextInt();
        };

        TestingTool<Integer> testingTool = new TestingTool(sortingAlgorithm, compare, generateRandom);
        testingTool.setEfficiency(TestingTool.Efficiency.N);
        testingTool.addTest(TestingTool.Tests.PRESORTED, 500);

    }
}
