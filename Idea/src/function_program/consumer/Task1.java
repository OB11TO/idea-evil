package function_program.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Task1 {

    public static void main(String[] args) {
        Consumer<Integer> consumer = System.out::println;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Predicate<Integer> predicate = (integer -> integer % 2 != 0);

        for (Integer number: list) {
            if (predicate.test(number)) {
                consumer.accept(number);
            }
        }

    }
}
