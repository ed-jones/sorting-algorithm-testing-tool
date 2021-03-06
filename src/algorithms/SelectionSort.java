package algorithms;

import helpers.FuncInterface;
import java.util.List;

import algorithms.interfaces.ISort;

public class SelectionSort<T> implements ISort<T> {
    public List<T> sort(List<T> input, FuncInterface<T> ICompare) {
        // step 1: loop from the beginning of the array to the second to last item
        for (int currentIndex = 0; currentIndex < input.size() - 1; currentIndex++)
        {
            // step 2: save a copy of the currentIndex
            int minIndex = currentIndex;
            // step 3: loop through all indexes that proceed the currentIndex
            for (int i = currentIndex + 1; i < input.size(); i++)
            {
                // step 4:  if the value of the index of the current loop is less
                //          than the value of the item at minIndex, update minIndex
                //          with the new lowest value index */
                if ( ICompare.compare(input.get(minIndex), input.get(i)))
                {
                    // update minIndex with the new lowest value index
                    minIndex = i;

                    NUM_CALLED++;
                }
            }
            // step 5: if minIndex has been updated, swap the values at minIndex and currentIndex
            if (minIndex != currentIndex)
            {
                T temp = input.get(currentIndex);
                input.set(currentIndex, input.get(minIndex));
                input.set(minIndex, temp);
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
