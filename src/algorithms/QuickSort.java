package algorithms;

import helpers.FuncInterface;
import java.util.List;

import algorithms.interfaces.ISort;

public class QuickSort<T> implements ISort<T> {
    public List<T> sort(List<T> input, FuncInterface<T> ICompare) {
        quickSort(input, 0, input.size() - 1, ICompare);
        return input;
    };

    private void quickSort(List<T> array, int startIndex, int endIndex, FuncInterface<T> ICompare)
    {
        // verify that the start and end index have not overlapped
        if (startIndex < endIndex)
        {
            // calculate the pivotIndex
            int pivotIndex = partition(array, startIndex, endIndex, ICompare);
            // quickSort the left sub-array
            quickSort(array, startIndex, pivotIndex, ICompare);
            // quickSort the right sub-array
            quickSort(array, pivotIndex + 1, endIndex, ICompare);  
        }
    }

    private int partition(List<T> array, int startIndex, int endIndex, FuncInterface<T> ICompare)
    {
        int pivotIndex = (startIndex + endIndex) / 2;
        T pivotValue = array.get(pivotIndex);
        startIndex--;
        endIndex++;

        while (true)
        {
            // start at the FIRST index of the sub-array and increment
            // FORWARD until we find a value that is > pivotValue
            do startIndex++; while (ICompare.compare(array.get(startIndex), pivotValue)) ;

            // start at the LAST index of the sub-array and increment
            // BACKWARD until we find a value that is < pivotValue
            do endIndex--; while (ICompare.compare(pivotValue, array.get(endIndex))) ;

            if (startIndex >= endIndex) return endIndex;

            // swap values at the startIndex and endIndex
            T temp = array.get(startIndex);
            array.set(startIndex, array.get(endIndex));
            array.set(endIndex, temp);
        }
    }
}

