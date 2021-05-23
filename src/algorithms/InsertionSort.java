package algorithms;

import helpers.FuncInterface;
import java.util.function.BiFunction;
import java.util.List;

public class InsertionSort<T> {
    public BiFunction<List<T>, FuncInterface<T>, List<T>> insertionSort = (input, ICompare) -> {
        for (int i = 1; i < input.size(); i++) {
            T value = input.get(i);
            int j = i - 1;
            while (j >= 0 && ICompare.compare(input.get(j), value)) {
                input.set(j + 1, input.get(j));
                j = j - 1;
            }
            input.set(j + 1, value);
        }
        return input;
    };
}
