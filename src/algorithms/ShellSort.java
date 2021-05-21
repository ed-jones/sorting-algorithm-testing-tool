package algorithms;

import helpers.FuncInterface;

public class ShellSort<T> {
    public T[] shellSort(T[] input, FuncInterface<T> ICompare)
    {
        /*
         * for-loop setup:
         *      1. set the gapSize to the length of the input / 2
         *      2. run the loop as long as gapSize > 0
         */
        for (int gapSize = input.length / 2; gapSize > 0; gapSize /= 2)
        {
            for (int currentIndex = gapSize; currentIndex < input.length; currentIndex++)
            {
                // save the currentIndex
                int currentIndexCopy = currentIndex;
                // save the value of the currentIndex
                T item = input[currentIndex];
                while (currentIndexCopy >= gapSize && ICompare.compare(input[currentIndexCopy - gapSize], item))
                {
                    input[currentIndexCopy] = input[currentIndexCopy - gapSize];
                    currentIndexCopy -= gapSize;
                }
                input[currentIndexCopy] = item;
            }
        }

        return input;
    }
}
