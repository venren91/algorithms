package euler;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;


/**
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
public class SumOfEvenValuedFibSeries {

    private static class FibonacciSupplier implements IntSupplier {
        int first = 0;
        int second = 1;

        @Override
        public int getAsInt() {
            int result = first + second;
            first = second;
            second = result;
            return result;
        }
    }


    public static void main(String[] args) {
        FibonacciSupplier fibonacciSupplier = new FibonacciSupplier();
        System.out.println(
                IntStream.generate(fibonacciSupplier)
                        .limit(400)
                        .filter(x -> (x > 0 && x < 4000000 && (x%2 == 0)))
                        .sum());
    }
}
