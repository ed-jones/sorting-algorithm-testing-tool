package testingtool;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import algorithms.interfaces.ISort;
import helpers.FuncInterface;
import helpers.TimeComplexityUtil;
import helpers.TimeUtil;
import testingtool.TestingTool.TestType;

public class Test<T> {

    private FuncInterface<T> ICompare;
    private ISort<T> sortingAlgorithm;
    private TestType typeOfTest;
    private List<T> originalList;
    private int listSize = 0;
    private Integer errorCount = 0;

    public Test() {
            
    }

    public Test(FuncInterface<T> _ICompare, ISort<T> _sortingAlgorithm, TestType _typeOfTest, List<T> _originalList) {
        ICompare = _ICompare;
        sortingAlgorithm = _sortingAlgorithm;
        typeOfTest = _typeOfTest;
        originalList = _originalList;
        listSize = originalList.size();
    }

    public void run() {
        System.out.println("------------------------------------------------------------------");
        switch (typeOfTest) {
            case PRESORTED:
                this.execPresorted();
                break;
            case RANDOM:
                this.execRandom();
                break;
            case REVERSE_SORTED:
                this.execReverseSorted();
                break;
            case NULL: 
                this.execNull();
                break; 
            default:
                break;
        }
        
        if(errorCount == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(errorCount + " tests failed.");
        }
        TimeUtil.stopClock();
        TimeUtil.outputMessage();
        
        TimeComplexityUtil.calcTimeComplexity(sortingAlgorithm.getCalled(), listSize);
        System.out.println("------------------------------------------------------------------");
    }

    public boolean validateLength(int expected, int actual) {
        System.out.println("Test 1: Validating length of list.");
        if(expected != actual) {
            System.out.println("Failed. ❌");
            errorCount++;
            return false;
        }
        System.out.println("Passed. ✅");
        return true;
    }

    public boolean validateListElements(List<T> originalList, List<T> sortedList) {
        System.out.println("Test 2: Validating elements of list.");
        if(!originalList.removeAll(sortedList) && !originalList.isEmpty()) {
            System.out.println("Failed. ❌");
            errorCount++;
            return false;
        };
        System.out.println("Passed. ✅");
        return true;
    }

    public boolean validateListSorted(List<T> sortedList) {
        System.out.println("Test 3: Validating if the list is sorted.");
        if(!sortedList.stream().sorted().collect(Collectors.toList()).equals(sortedList)) {
            System.out.println("Failed. ❌");
            errorCount++;
            return false;
        };
        System.out.println("Passed. ✅");
        return true;
    }

    private void execRandom() {
        System.out.println("Starting random list test:");

        TimeUtil.startClock();
        // Create copy of original List
        List<T> sortedList = new ArrayList<T>();
        for(T l : originalList)
            sortedList.add(l);

        sortedList = sortingAlgorithm.sort(sortedList, ICompare);

        // Check Length
        validateLength(originalList.size(), sortedList.size());

        // Check that all elements are the same
        validateListElements(originalList, sortedList);

        // Check list is actually sorted
        validateListSorted(sortedList);
    }

    private void execReverseSorted() {
        System.out.println("Starting reverse-sorted list test:");

        // Create copy of original List
        List<T> sortedList = new ArrayList<T>();
        for(T l : originalList)
            sortedList.add(l);

        // pre sort list
        sortedList = sortingAlgorithm.sort(sortedList, ICompare);
        // Reverse list
        Collections.reverse(sortedList);
        sortingAlgorithm.resetCalled();

        TimeUtil.startClock();

        sortedList = sortingAlgorithm.sort(sortedList, ICompare);

        // Check Length
        validateLength(originalList.size(), sortedList.size());

        // Check that all elements are the same
        validateListElements(originalList, sortedList);

        // Check list is actually sorted
        validateListSorted(sortedList);
    }

    private void execPresorted() {
        System.out.println("Starting pre-sorted list test:");

        // Create copy of original List
        List<T> sortedList = new ArrayList<T>();
        for(T l : originalList)
            sortedList.add(l);

        //pre sort list
        sortedList = sortingAlgorithm.sort(sortedList, ICompare);
        sortingAlgorithm.resetCalled();
        
        TimeUtil.startClock();

        sortedList = sortingAlgorithm.sort(sortedList, ICompare);

        // Check Length
        validateLength(originalList.size(), sortedList.size());

        // Check that all elements are the same
        validateListElements(originalList, sortedList);

        // Check list is actually sorted
        validateListSorted(sortedList);
    }

    private void execNull() {
        System.out.println("Starting null list test:");

        TimeUtil.startClock();
        // Make originalList null
        originalList = new ArrayList<T>();

        // Create copy of original List
        List<T> sortedList = new ArrayList<T>();
        for(T l : originalList)
            sortedList.add(l);

        sortedList = sortingAlgorithm.sort(sortedList, ICompare);

        // Check Length
        validateLength(originalList.size(), sortedList.size());

        // Check that all elements are the same
        validateListElements(originalList, sortedList);

        // Check list is actually sorted
        validateListSorted(sortedList);
    }
}
