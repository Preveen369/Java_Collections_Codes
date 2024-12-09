import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Collections;

public class Vectors {
    public static void main(String[] args) throws InterruptedException {
        // Vectors are part of Collection API, that works similar to ArrayList
        // Differences are found in performance, speed, multi-threading factors:

        // ArrayList's are not synchronized and not thread-safe, faster execution
        // whereas the vector's are synchronized and thread-safe, slower execution

        // Vector's would be useful only in multithreading approach
        // But as an alternative we could use Collections.synchronizedList(ArrayList)
        // for synchronization of ArrayList's similar to vector's

        int size = 1000000;

        // In Single - Threaded Environment Approach:
        List<Integer> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Added " + size + " elements to ArrayList: " + (end - start) + "ms");

        List<Integer> vector = new Vector<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            vector.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Added " + size + " elements to Vector: " + (end - start) + "ms");


        // In a Multi - Threaded Environment Approach:
        List<Integer> multithreadedList = Collections.synchronizedList(new ArrayList<>());
        start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedList.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedList.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        end = System.currentTimeMillis();
        System.out.println("Added elements in Multi-Threaded way to List: " + (end - start) + "ms");
        System.out.println("Size is: " + multithreadedList.size());


        List<Integer> multithreadedVector = new Vector<>();
        start = System.currentTimeMillis();

        t1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedVector.add(i);
            }
        });

        t2 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedVector.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        end = System.currentTimeMillis();
        System.out.println("Added elements in Multi-Threaded way to Vector: " + (end - start) + "ms");
        System.out.println("Size is: " + multithreadedVector.size());
    }
}
