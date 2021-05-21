package helpers;

@FunctionalInterface
public interface FuncInterface<T>
{
    Boolean compare(T x, T y);
}