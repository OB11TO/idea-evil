package function_program.functions.predicate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

public class Task3 {

    /**
     * В вашем примере мы использовали метод removeIf(), который принимает Predicate — это одноаргументный функциональный интерфейс. Однако мы работаем с Map.Entry, который содержит пару ключ-значение, и для проверки условия на основе двух аргументов (ключа и значения) мы использовали BiPredicate.
     *
     * Так как removeIf() принимает Predicate<Map.Entry<K, V>>, нам нужно внутри этого предиката использовать наш BiPredicate, проверяя его с двумя аргументами: ключом (entry.getKey()) и значением (entry.getValue()).
     *
     * Конкретно в этом случае:
     *
     * entrySet().removeIf() ожидает лямбду или предикат для проверки каждого Map.Entry.
     * Мы передаем туда лямбду, которая принимает entry, и внутри нее вызываем наш BiPredicate, используя его метод test(), передавая два аргумента: entry.getKey() и entry.getValue(). Это позволяет нам использовать BiPredicate в контексте стандартного Predicate.
     * Весь процесс выглядит так:
     *
     * java
     * Copy code
     * map.entrySet().removeIf(entry -> !biPredicate.test(entry.getKey(), entry.getValue()));
     * entry -> !biPredicate.test(entry.getKey(), entry.getValue()) — это лямбда-выражение, которое проверяет каждую запись (Map.Entry<K, V>) с помощью BiPredicate.
     * biPredicate.test(entry.getKey(), entry.getValue()) — мы явно передаем ключ и значение в наш BiPredicate, где они сравниваются с условием.
     * Таким образом, мы эффективно преобразуем использование BiPredicate в стандартный Predicate, который ожидается методом removeIf().
     * @param args
     */
    public static void main(String[] args) {


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "FUCK");
        map.put(2, "GG");
        map.put(3, "FFFFUCK");
        map.put(4, "FUCK");

        map.forEach((integer, s) -> System.out.println(integer + " - " + s));

        BiPredicate<Integer, String> biPredicate = Task3::mapToFuck;
        Task3 task3 = new Task3();
        Task3.Test test = task3.new Test();

        BiPredicate<Integer, String> biPredicateTest = test::gg;
        BiPredicate<Integer, String> biPredicate2 = (k,v) -> v.length() == k;

        map.entrySet().removeIf(entry -> !biPredicateTest.test(entry.getKey(), entry.getValue()));

        map.forEach((integer, s) -> System.out.println(integer + " - " + s));
    }

    private static boolean mapToFuck(Integer integer, String s) {
        return s.length() == integer;
    }

    class Test {
        public boolean gg(Integer integer, String string) {
            return string.length() == integer;
        }
    }
}