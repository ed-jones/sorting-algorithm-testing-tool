package algorithms;

import helpers.FuncInterface;
import java.util.List;

import algorithms.interfaces.ISort;

public class ShellSort<T> implements ISort<T> {
    public List<T> sort(List<T> input, FuncInterface<T> ICompare)
    {
        for (int gapSize = input.size() / 2; gapSize > 0; gapSize /= 2)
        {
            for (int currentIndex = gapSize; currentIndex < input.size(); currentIndex++)
            {
                // save the currentIndex
                int currentIndexCopy = currentIndex;
                // save the value of the currentIndex
                T item = input.get(currentIndex);
                while (currentIndexCopy >= gapSize && ICompare.compare(input.get(currentIndexCopy - gapSize), item))
                {
                    input.set(currentIndexCopy, input.get(currentIndexCopy - gapSize));
                    currentIndexCopy -= gapSize;

                    NUM_CALLED++;
                }
                input.set(currentIndexCopy, item);
            }
        }

        return input;
    }

    private int NUM_CALLED = 0;

    public int getCalled() {
        return NUM_CALLED;
    }

    public void resetCalled() {
        NUM_CALLED = 0;
    }
}
