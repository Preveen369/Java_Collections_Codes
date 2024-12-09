import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamAPIDemo {
    // Stream API is found in java.util.stream package
    // used to simplify the operations on collection of objects
    public static void main(String[] args) {
        // asList() : to convert an array into a list type
        List<Integer> nums = Arrays.asList(4, 5, 2, 1, 6, 3);

        // to retrieve the numbers from nums list:
        // by normal for loop methods:
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }

        for (int n : nums) {
            System.out.println(n);
        }

        // to return the sum of all the numbers by normal method:
        int sum = 0;
        for (int n : nums) {
            if (n % 2 == 0) {
                n = n * 2;
                sum = sum + n;
            }
        }

        // System.out.println(sum);

        // forEach method (direct approach):
        nums.forEach(n -> System.out.println(n));

        /* WORKING OF FOREACH METHOD */
        Consumer<Integer> con = new Consumer<Integer>() {
            // perform an action
            public void accept(Integer n) {
                System.out.println(n);
            }
        };

        // forEach method (requires Consumer object):
        nums.forEach(con);

        // Streams doesn't reflect changes the objects of original list
        // Streams contains the same list/collection objects which we define
        // Streams are non-reusable, declared, used only once

        Stream<Integer> s1 = nums.stream();
        Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);
        Stream<Integer> s3 = s2.map(n -> n * 2);
        // in reduce() method: c -> carry, 0 ->initial value, e -> element
        // reduce() performs binary addtitions on the values of stream s3
        int result = s3.reduce(0, (c, e) -> c + e);

        // SHORT-HANDED VERSION OF STREAM (which returns a result value)
        // int result = nums.stream()
        // .filter(n -> n % 2 == 0)
        // .map(n -> n * 2)
        // .reduce( 0, (c, e) -> c + e);

        // System.out.println(result);
        // s3.forEach(n -> System.out.println(n));

        /* WORKING OF FILTER METHOD */
        Predicate<Integer> p = new Predicate<Integer>() {
            // perform an condition test
            public boolean test(Integer n) {
                if (n % 2 == 0) // pass the value
                    return true;
                else // block the value
                    return false;
            }
        };

        /* WORKING OF MAP METHOD */
        Function<Integer, Integer> fun = new Function<Integer, Integer>() {
            // perform an operation
            public Integer apply(Integer n) {
                return n * 2;
            }
        };

        /* WORKING OF REDUCE METHOD */
        int res = nums.stream()
                .filter(p)
                .map(n -> n * 2)
                .reduce(0, (c, e) -> c + e);

        System.out.println(res);

        // SHORT-HANDED VERSION OF STREAM (supports single-threading)
        // (without returning a value)
        Stream<Integer> sortedValues = nums.stream()
                .filter(p)
                .sorted();

        sortedValues.forEach(n -> System.out.println(n));

        // SHORT-HANDED VERSION OF PARALLELSTREAM (supports multi-threading)
        // (without returning a value)
        Stream<Integer> sortedVals = nums.parallelStream()
                .filter(p)
                .sorted();

        sortedVals.forEach(n -> System.out.println(n));

    }
}
