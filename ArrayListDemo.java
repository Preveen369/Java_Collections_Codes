import java.util.ArrayList;
import java.util.Collection;
// import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Collection API data structures: [ArrayList & List]
        // Use Collection Interface only for add, fetch values from list
        Collection<Integer> datas = new ArrayList<Integer>();

        // To define the data types in collection API, we use Generics.
        // You can define the type of an object to which data type class it belongs in
        // angular brackets:

        // If we do not specify the datatype of a collection object, then it will give a
        // run-time error.
        // else error can be checked during the compile-time itself.
        datas.add(10);
        datas.add(20); // Objects, not integer
        datas.add(30);
        datas.add(40);
        datas.add(30);
        // datas.add("60"); // error
        // System.out.println(datas);

        // Only to be used when working with List Interface
        // System.out.println(datas.indexOf(40));
        // System.out.println(datas.get(datas.size()-1));
        // System.out.println(datas.contains(20));


        // Accessing each object's value from collection (arraylist) "datas":
        for (Object x : datas) {
            // Typecast Object to Integer type
            // avoids the ClassCastException error
            Integer num = (Integer) x;
            System.out.println(num);
        }

    }
}
