package algorithms;

import helpers.FuncInterface;

import java.net.CacheRequest;
import java.util.List;

import algorithms.interfaces.ISort;


public class BubbleSort<T> implements ISort<T> {
    public List<T> sort(List<T> input, FuncInterface<T> ICompare){
        int n = input.size();
        while (n > 0)
        {
            int lastModifiedIndex = 0;
            for (int currentIndex = 1; currentIndex < n; currentIndex++)
            {
                // if the item at the previous index is greater than the item at the `currentIndex`, swap them
                if (ICompare.compare(input.get(currentIndex - 1), input.get(currentIndex)))
                {
                    // swap
                    T temp = input.get(currentIndex - 1);
                    input.set(currentIndex - 1, input.get(currentIndex));
                    input.set(currentIndex, temp);
                    // save the index that was modified
                    lastModifiedIndex = currentIndex;

                    NUM_CALLED++;
                }
            }
            // save the last modified index so we know not to iterate past it since all proceeding values are sorted
            n = lastModifiedIndex;
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
