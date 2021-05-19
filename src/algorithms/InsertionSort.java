import java.util.function.Function;

public class InsertionSort<T> {
    public Function<T[], Function<T, T, Boolean>, T[]> insertionSort = (input, compare) -> {
        for (int i = 1; i < input.length; i++) {
            T value = input[i];
            int j = i - 1;
            while (j >= 0 && compare(input[j], value)) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = value;
        }
        return input;
    };
}
