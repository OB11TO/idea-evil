package function_program.functions.function;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task1 {

    public static void main(String[] args) {
//        Integer integer = 12311;
//        BigInteger bigInteger = BigInteger.valueOf(integer);
//        boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(integer));

        Integer[] array = new Integer[]{5, 6, 7, 8, 9, 10};

        Predicate<Integer> predicate = (value) -> {
            BigInteger bigInteger = BigInteger.valueOf(value);
            return bigInteger.isProbablePrime((int) Math.log(value));
        };

        Function<Integer[], Integer> function = (Integer[] arr) -> {
            int count = 0;
            for (Integer value : arr) {
                count += predicate.test(value) ? 1 : 0;

            }
            return count;
        };

        Integer result = function.apply(array);
        System.out.println(result);

        AtomicInteger count = new AtomicInteger();

        long count1 = Arrays.stream(array)
                .filter((value) -> BigInteger.valueOf(value).isProbablePrime((int) Math.log(value)))
                .count();

        System.out.println(count1);

    }
}