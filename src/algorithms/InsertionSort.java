package algorithms;

import helpers.FuncInterface;
import java.util.List;

import algorithms.interfaces.ISort;

public class InsertionSort<T> implements ISort<T> {
    public List<T> sort(List<T> input, FuncInterface<T> ICompare) {
        for (int i = 1; i < input.size(); i++) {
            T value = input.get(i);
            int j = i - 1;
            while (j >= 0 && ICompare.compare(input.get(j), value)) {
                input.set(j + 1, input.get(j));
                j = j - 1;

                NUM_CALLED++;
            }
            input.set(j + 1, value);
        }
        return input;
    };

    private int NUM_CALLED = 0;

    public int getCalled() {
        return NUM_CALLED;
    }

    public void resetCalled() {
        NUM_CALLED = 0;
    }
}
