import java.util.ArrayList;
import java.util.List;

class Container<T extends Number> {
    T value; // Infers the type during object creation

    public void show() {
        // To determine the generic data type of value
        System.out.println(value.getClass().getName());
    }

    // Even the getters & setters use the generic types(T)
    // public T getValue() {
    // return value;
    // }

    // public void setValue(T value) {
    // this.value = value;
    // }

    // T becomes the Number (for eg.,) as specified in obj
    // where the ArrayList of (?) (Integer) supports Number type
    // (supports the sub classes of T type)
    public void demo_sub(ArrayList<? extends T> obj) {}

    // T becomes the Integer (for eg.,) as specified in obj
    // where the Super classes (?) (Number) supports Integer(T)
    // (supports the super classes of T type)
    public void demo_super(ArrayList<? super T> obj) {}

}

public class GenericsDemo {
    public static void main(String[] args) {
        // type - safety on data types (primitive types)
        // int value = 5;

        // Default type of collection : Object type (Super-Class)
        // By default, collection doesn't provide type-safety, as it is raw type
        // But to achieve the type-safety, we use generics <types> & notations
        List<Integer> values = new ArrayList<>();
        values.add(2);
        // values.add("Hello"); // gives error at compile-time

        // If type-safety is not achieved we may get error at run-time
        // int i = Integer.parseInt(values.get(1).toString());
        // System.out.println(i); -> gives NumberFormatException at runtime

        // Generics<> supports only classes, not primitive types
        Container<Integer> obj = new Container<>();
        obj.value = 45;
        obj.show();

        // For eg., here in methods by generics, Container supports Number type,
        // but the ArrayList supports only the Integer type
        // {extends is used in method}
        // obj.demo_sub(new ArrayList<Integer>());

        // {super is used in method}, Container supports Integer type,
        // but the ArrayList supports only the Number type
        obj.demo_super(new ArrayList<Number>());

    }
}
