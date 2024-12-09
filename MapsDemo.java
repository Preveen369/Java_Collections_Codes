import java.util.HashMap;
import java.util.Map;
import java.util.Set;
// import java.util.Hashtable;

// HashMap : class used for normal map structures 
// (but externally synchronized, fast)
// HashTable : class used for synchronized map structures
// (used with multiple - threads, slow)
// LinkedHashMap: To make insertion order of HashMap to be fixed
// TreeHashMap: To make the HashMap in the sorted format

public class MapsDemo {
    public static void main(String[] args) {
        // Maps are data structures part of Collection: [Maps: HashMap & HashTable]
        // Map is a collection of key-value pairs. in this, for every value of an
        // element, a key is associated with it.
        // Map itself is in an interface that supports key-value pairs.
        // A class that implements it (map) is called HashMap.
        Map<String, Integer> students = new HashMap<>();
        students.put("Preveen", 50);
        students.put("Ragul", 51);
        students.put("Kiran", 44);
        students.put("Sivapranav", 57);
        students.put("Kiran", 60);

        // System.out.println(students);    ->   returns the map
        // System.out.println(students.get("Preveen"));
        // System.out.println(students.get("Ragul"));

        // System.out.println(students.keySet()); -> set of keys
        // System.out.println(students.values()); -> list of values

        // Two ways of retrieving the values from the Map interface (HashMap):
        // i] using keySet() method of Set<T> interface, to iterate through keys
        Set<String> keys = students.keySet();
        for (String key : keys) {
            System.out.println(key + " : " + students.get(key));
        }

        // ii] using entrySet() method of Set<Map.Entry<K, V>> interface, to iterate through entries [{key:value} pairs]
        // retrieving the keys and values of each entry by: getKey() and getValue() respectively:
        Set<Map.Entry<String, Integer>> entrys = students.entrySet();
        for (Map.Entry<String, Integer> e : entrys) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
