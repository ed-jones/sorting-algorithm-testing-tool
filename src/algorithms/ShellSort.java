package algorithms;

import helpers.FuncInterface;
import java.util.List;

public class ShellSort<T> {
    public List<T> shellSort(List<T> input, FuncInterface<T> ICompare)
    {
        /*
         * for-loop setup:
         *      1. set the gapSize to the length of the input / 2
         *      2. run the loop as long as gapSize > 0
         */
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
                }
                input.set(currentIndexCopy, item);
            }
        }

        return input;
    }
}
