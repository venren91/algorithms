package euler;

/**
 * Question: If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 */

import org.junit.Assert;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class SumOfMultiplesOfThreeOrFive {
    private int execute(int limit){
        IntPredicate isMultipleOfThree = (x) -> (x%3 == 0);
        IntPredicate isMultipleOfFive = (x) -> (x%5 == 0);
        return IntStream.range(1,limit).filter(isMultipleOfThree.or(isMultipleOfFive)).reduce(0,Integer::sum);
    }

    public static void main(String[] args) {
        Integer result = new SumOfMultiplesOfThreeOrFive().execute(1000);
        Assert.assertTrue(result == 233168);
    }
}
