// A NORMAL CLASS TO DISPLAY THE DEVELOPER PROFILE DATA:
// class Developer{
//     private final int id;
//     private final String name;

//     public Developer(int id, String name) {
//         this.id = id;
//         this.name = name;
//     }

//     // To convert the Data to JSON format
//     public int getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     // To print the state values of the object in string format:
//     @Override
//     public String toString() {
//         return "Developer [id=" + id + ", name=" + name + "]";
//     }

//     // To generate the memory address of the object inside the heap:
//     @Override
//     public int hashCode() {
//         final int prime = 31;
//         int result = 1;
//         result = prime * result + id;
//         result = prime * result + ((name == null) ? 0 : name.hashCode());
//         return result;
//     }

//     // To compare two object based on values, not on memory
//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null)
//             return false;
//         if (getClass() != obj.getClass())
//             return false;
//         Developer other = (Developer) obj;
//         if (id != other.id)
//             return false;
//         if (name == null) {
//             if (other.name != null)
//                 return false;
//         } else if (!name.equals(other.name))
//             return false;
//         return true;
//     }

// }


// RECORD CLASS: to create data carrier class
// (making objects for transferring the datas only)
// Instance variables are: private final by default 
// Records can't extend other classes but implements interfaces

// It simplifies class definition code, by avoiding:
// instance variables declaration, implementations of:
// toString(), constructors, hashCode(), equals(), getters()


// A RECORD CLASS TO DISPLAY THE DEVELOPER PROFILE DATA:
record Developer(int id, String name) /*implements Cloneable*/ {

    static int num; // only static(class) variables can be declared
    // int age; (error) -> instance variables must be declared in creation of record

    // Canonical Constructor: parameterized constructor (similar to record)
    // public Developer(int id, String name) {
    //     if (id == 0) ->  Exception Check
    //         throw new IllegalArgumentException("id can't be zero!!");
    //     this.id = id;
    //     this.name = name;
    // }

    // Compact Canonical Constructor: (no need to initialize the state)
    public Developer {
        if (id == 0)
            throw new IllegalArgumentException("id can't be zero!!");
    }

    // Calling the default constructor
    // public Developer(){
    //     this(0, "");  -> needed to invoke canonical constructor
    // }

    // able to establish other methods:
    public void show(){}

}

public class RecordsDemo {
    public static void main(String[] args) {

        // creating 2 objects with initializing values:
        Developer dev1 = new Developer(1, "Preveen");
        Developer dev2 = new Developer(2, "Pranesh");
        // Need to define the default constructor with this() constructor:
        // Developer dev3 = new Developer();  
        
        // toString(), equals() are implemented by default in record class:
        System.out.println(dev1.equals(dev2));  // compare by value (equals)

        // from normal class
        // System.out.println(dev1.getName()); // access state values by getter()
        // System.out.println(dev1.getId());   // access state values by getter()

        // from record class
        System.out.println(dev1.name());    // access state values of object
        System.out.println(dev1.id());      // access state values of object
    }
}
