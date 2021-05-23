/*
~~~ USAGE ~~~
// Generate Integer ArrayList of size 5 with elements between 0 - 9 
RandomList<Integer> i = new RandomList<>(rand -> rand.nextInt(10), 5);

// Generate Double ArrayList of size 5 with elements between 0.0 - 9.0 
RandomList<Double> d = new RandomList<>(rand -> rand.nextDouble() * 10, 5);

// Generate Character ArrayList of size 5 with elements between a - z 
RandomList<Character> s = new RandomList<Character>(rand -> (char)(rand.nextInt(26) + 'a'), 5);
*/
package testingtool;

import java.util.function.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList<T>
{
    private List<T> list;

    public RandomList (Function<Random, T> creator, int size) {
        list = new ArrayList<T>();

        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            list.add(creator.apply(rand));
        }
    }

    public List<T> getList() {
        return list;
    }
}
