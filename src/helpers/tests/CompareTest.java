package helpers.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import helpers.FuncInterface;

public class CompareTest {
    FuncInterface<Integer> compare = (a, b) -> a > b;

    @Test
    public void testCompare() {
        assertTrue(compare.compare(2, 1));
        assertFalse(compare.compare(1, 2));
    }
}
