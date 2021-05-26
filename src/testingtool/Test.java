package testingtool;

import java.util.List;
import java.util.stream.Collectors;

import algorithms.interfaces.ISort;
import helpers.FuncInterface;
import testingtool.TestingTool.TestType;

public class Test<T> {

    private FuncInterface<T> ICompare;
    private ISort<T> sortingAlgorithm;
    private TestType typeOfTest;
    private List<T> originalList;
    private Integer errorCount = 0;

    public Test(FuncInterface<T> _ICompare, ISort<T> _sortingAlgorithm, TestType _typeOfTest, List<T> originalList) {
        ICompare = _ICompare;
        sortingAlgorithm = _sortingAlgorithm;
        typeOfTest = _typeOfTest;
    }

    public void run() {
        try {
            switch (typeOfTest) {
                case PRESORTED:
                    this.testPresorted();
                    break;
                case RANDOM:
                    this.testRandom();
                    break;
                case REVERSE_SORTED:
                    this.testReverseSorted();
                    break;
                case NULL: 
                    this.testNull();
                    break; 
                default:
                    break;
            }
        } finally {
            if(errorCount == 0) {
                System.out.println("All tests passed!");
            } else {
                System.out.println(errorCount + " tests failed.");
            }
        }
        
    }

    private void testRandom() {
        System.out.println("Starting random list test");
        // Generate sorted List
        // FIX: originalList will get to sorted as well as List<T> is referenced
        List<T> sortedList = sortingAlgorithm.sort(originalList, ICompare);

        // Check Length
        validateLength(originalList.size(), sortedList.size());

        // Check that all elements are the same
        validateListElements(originalList, sortedList);

        // Check list is actually sorted
        validateListSorted(sortedList);
    }

    private boolean validateLength(int expected, int actual) {
        // TODO: add better output info
        if(expected != actual) {
            System.out.println("Test Failed");
            errorCount++;
            return false;
        }
        return true;
    }

    private boolean validateListElements(List<T> originalList, List<T> sortedList) {
        if(!originalList.removeAll(sortedList)) {
            System.out.println("Test Failed");
            errorCount++;
            return false;
        };
        return true;
    }

    private boolean validateListSorted(List<T> sortedList) {
        if(!sortedList.stream().sorted().collect(Collectors.toList()).equals(sortedList)) {
            System.out.println("Test Failed");
            errorCount++;
            return false;
        };
        return true;
    }

    private void testReverseSorted() {

    }

    private void testPresorted() {

    }

    private void testNull() {

    }
}
