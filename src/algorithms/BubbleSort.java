package algorithms;

import helpers.FuncInterface;

public class BubbleSort<T> {
    public T[] bubbleSort(T[] input, FuncInterface<T> ICompare){
        int n = input.length;
        while (n > 0)
        {
            int lastModifiedIndex = 0;
            for (int currentIndex = 1; currentIndex < n; currentIndex++)
            {
                // if the item at the previous index is greater than the item at the `currentIndex`, swap them
                if (ICompare.compare(input[currentIndex - 1], input[currentIndex]))
                {
                    // swap
                    T temp = input[currentIndex - 1];
                    input[currentIndex - 1] = input[currentIndex];
                    input[currentIndex] = temp;
                    // save the index that was modified
                    lastModifiedIndex = currentIndex;
                }
            }
            // save the last modified index so we know not to iterate past it since all proceeding values are sorted
            n = lastModifiedIndex;
        }
        return input;
    };
}
