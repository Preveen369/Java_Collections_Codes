import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

// 2 LOGICS: SORTED LIST OF STUDENTS & SORTED LIST OF NUMBERS
// (approaches used: i] comparing 2 student rollno's each)
// (approaches used: ii] comparing each 2 numbers last digit's)

// To implement the natural sort in any class, we need to 
// implement that class with Comparable<T> interface:
// But, Integer class implements Comparable inteface by default

class Student implements Comparable<Student> {
    // Comparable<T>: Defines the "natural" ordering of
    // objects within the class itself.
    int rollno;
    String name;

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    // To display each student details as string type:
    public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name + "]";
    }

    // Implementing method of Comparable interface
    public int compareTo(Student that) {
        if (this.rollno > that.rollno)
            return 1; // Swap
        else
            return -1; // Don't Swap
    }

}

public class CollectionSort {
    // Comparator<T>: Allows for custom sorting logic, separate
    // from the class being sorted
    public static void main(String[] args) {
        // To implement the comparator sort using Comparator<T> interface:
        Comparator<Student> com = new Comparator<Student>() {
            public int compare(Student i, Student j) {
                // Implementing compare() method:
                if (i.rollno > j.rollno)
                    return 1; // Swap
                else
                    return -1; // Don't Swap
            }
        };

        /*
         * Another method to implement the comparator sort using lambda expressions:
         * Comparator<Student> com = (i, j) -> (i.rollno > j.rollno) ? 1 : -1;
         */

        // To implement the Students List collection:
        List<Student> studs = new ArrayList<>();

        // Adding each student object to studs list:
        studs.add(new Student(50, "Preveen"));
        studs.add(new Student(60, "Suprakash"));
        studs.add(new Student(44, "Kiran"));
        studs.add(new Student(34, "Arunkumar"));
        studs.add(new Student(57, "Sivapranav"));
        // System.out.println(studs); -> returns list of students

        // Perform Comparator sort (comparision through other class: here ->
        // CollectionSort class)
        Collections.sort(studs, com);
        // Perform Natural sort (comparision within same class: here -> Student class)
        // Collections.sort(studs);

        for (Student s : studs) {
            // retrieve each student's details
            System.out.println(s);
        }

    }
}
