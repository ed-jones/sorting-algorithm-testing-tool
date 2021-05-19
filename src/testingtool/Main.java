package testingtool;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Function<Int, Int, Boolean> compare = (a, b) -> a > b;
        Function<Int[], Function<Int, Int, Boolean>, Int[]> sortingAlgorithm = (input, compare) -> input;
        Function<Int> generateRandom = () -> {
            Random rnd = new Random();
            rnd.setSeed(100);
            return rnd.nextInt(100);
        };

        TestingTool testingTool = new TestingTool<Int>(sortingAlgorithm, compare, generateRandom);
        testingTool.setEfficiency(TestingTool.Efficiency.N);
        testingTool.addTest(TestingTool.Tests.PRESORTED, 500);
    }
}