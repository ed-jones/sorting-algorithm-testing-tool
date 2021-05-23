package algorithms;

import helpers.FuncInterface;
import java.util.List;

public class SelectionSort<T> {
    public List<T> selectionSort(List<T> input, FuncInterface<T> ICompare) {
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
}
