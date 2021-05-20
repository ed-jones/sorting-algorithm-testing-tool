package algorithms;

public class QuickSort<T extends Comparable<? super T>> {

    public T[] quickSort(T[] input) {
        sort(input, 0, input.length - 1);
        
        return input;
    };

    private void sort(T[] array, int startIndex, int endIndex)
    {
        // verify that the start and end index have not overlapped
        if (startIndex < endIndex)
        {
            // calculate the pivotIndex
            int pivotIndex = partition(array, startIndex, endIndex);
            // sort the left sub-array
            sort(array, startIndex, pivotIndex);
            // sort the right sub-array
            sort(array, pivotIndex + 1, endIndex);  
        }
    }

    private int partition(T[] array, int startIndex, int endIndex)
    {
        int pivotIndex = (startIndex + endIndex) / 2;
        T pivotValue = array[pivotIndex];
        startIndex--;
        endIndex++;

        while (true)
        {
            // start at the FIRST index of the sub-array and increment
            // FORWARD until we find a value that is > pivotValue
            do startIndex++; while (array[startIndex].compareTo(pivotValue) < 0) ;

            // start at the LAST index of the sub-array and increment
            // BACKWARD until we find a value that is < pivotValue
            do endIndex--; while (array[endIndex].compareTo(pivotValue) > 0) ;

            if (startIndex >= endIndex) return endIndex;

            // swap values at the startIndex and endIndex
            T temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
        }
    }
}

