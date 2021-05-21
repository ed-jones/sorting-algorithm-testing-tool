package algorithms;

import helpers.FuncInterface;

public class HeapSort<T> {
    
    public T[] heapSort(T[] input, FuncInterface<T> ICompare)
    {
        int size = input.length;

        // build heapSort (rearrange input)
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(input, size, i, ICompare);

        // one by one extract an element from heapSort
        for (int i = size - 1; i >= 0; i--)
        {
            // move current root to end
            T temp = input[0];
            input[0] = input[i];
            input[i] = temp;

            // call max heapify on the reduced heapSort
            heapify(input, i, 0, ICompare);
        }

        return input;
    }

    // to heapify a subtree rooted with node i which is an index in input[]
    void heapify(T[] input, int size, int i, FuncInterface<T> ICompare)
    {
        int max   = i; // initialize max as root
        int left  = 2 * i + 1;
        int right = 2 * i + 2;

        // if left child is larger than root
        if (left < size && ICompare.compare(input[left], input[max]))
            max = left;

        // if right child is larger than max
        if (right < size && ICompare.compare(input[right], input[max]))
            max = right;

        // if max is not root
        if (max != i)
        {
            // swap
            T temp = input[i];
            input[i] = input[max];
            input[max] = temp;

            // recursively heapify the affected sub-tree
            heapify(input, size, max, ICompare);
        }
    }
}
