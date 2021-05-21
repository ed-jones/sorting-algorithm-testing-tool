package algorithms;

import helpers.FuncInterface;
import java.util.function.BiFunction;

public class InsertionSort<T> {
    public BiFunction<T[], FuncInterface<T>, T[]> insertionSort = (input, ICompare) -> {
        for (int i = 1; i < input.length; i++) {
            T value = input[i];
            int j = i - 1;
            while (j >= 0 && ICompare.compare(input[j], value)) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = value;
        }
        return input;
    };
}
