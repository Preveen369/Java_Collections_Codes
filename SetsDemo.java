import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetsDemo {
    public static void main(String[] args) {
        // Collection API data structures: [Sets(normal set) & TreeSet(sorted set)]
        // Use Collection (or) Set Interface.
        Set<Integer> datas = new TreeSet<Integer>();

        // If we do not specify the datatype of a collection object, then it will give
        // a run-time error.
        // else error can be checked during the compile-time itself.
        datas.add(10);
        datas.add(20);
        datas.add(30);
        datas.add(40);

        // (method-1)
        // Accessing each of the values from "datas" set by iterators:
        Iterator<Integer> values = datas.iterator();
        while (values.hasNext()) // to check whether the next value is present
            System.out.println(values.next()); // display the iterated value

        System.out.println();

        // (method-2)
        // Accessing each object's value from collection (hashset/treeset) "datas":
        for (int num : datas) {
            System.out.println(num);
        }

    }
}
