import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

// Serialization is the conversion of the state of an object into a byte stream;
// deserialization does the opposite
// Classes that are eligible for serialization need to implement a special
// marker interface, Serializable.

// static fields belong to a class (as opposed to an object) and are not serialized
// use the keyword 'transient' to ignore class fields during serialization

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    static String country = "INDIA";
    private int age;
    private String name;
    transient int height;

    // getters and setters for age & name fields
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [age = " + age + ", name = " + name + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}

public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setAge(18);
        person.setName("Preveen");

        File f = new File("details.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person p1 = (Person) ois.readObject();
        ois.close();
        System.out.println(p1);

        // for assertions,use -ea flag in "java (-ea) classname" to enable assertions 
        // comparing the state values before & after serialization:
        assert p1.getAge() == person.getAge() : "Age mismatch";
        assert p1.getName().equals(person.getName()) : "Name mismatch";
    }
}