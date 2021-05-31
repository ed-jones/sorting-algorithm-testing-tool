package testingtool.tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithms.QuickSort;
import algorithms.interfaces.ISort;
import helpers.FuncInterface;
import testingtool.RandomList;


public class TestClassTest {

    testingtool.Test<Integer> t;
    RandomList<Integer> randomList = new RandomList<>();
    List<Integer> actualList;
    private ISort<Integer> sortingAlgorithm;
    FuncInterface<Integer> ICompare;

    @BeforeEach
    public void initEach() {
       t = new testingtool.Test<Integer>();
       actualList = randomList.generateList(rand -> rand.nextInt(10), 5);
       sortingAlgorithm = new QuickSort<Integer>();
       ICompare = (a, b) -> a > b;
    }
    
    @Test
    void testValidateLength() {
        List<Integer> expectedList = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++) {
            expectedList.add(i);
        }
        // Test success case
        assertTrue(t.validateLength(expectedList.size(), actualList.size()));
        // Test failure case
        assertFalse(t.validateLength(new ArrayList<Integer>().size(), actualList.size()));
    }

    @Test
    void testValidateListElements() {
        List<Integer> testList = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++) {
            testList.add(i);
        }
        assertTrue(t.validateListElements(actualList, actualList));
    }

    @Test
    void testValidateListSorted() {
        sortingAlgorithm.sort(actualList, ICompare);
        assertTrue(t.validateListSorted(actualList));
        actualList.add(-1);
        assertFalse(t.validateListSorted(actualList));
    }
}
