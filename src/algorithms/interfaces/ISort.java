package algorithms.interfaces;

import java.util.List;
import helpers.FuncInterface;

public interface ISort<T> {
    List<T> sort(List<T> input, FuncInterface<T> ICompare);
}
