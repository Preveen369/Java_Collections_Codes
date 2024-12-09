import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

// Custom serialization can be particularly useful when trying to serialize an object that
// has some unserializable attributes. (by overriding readObject() & writeObject() methods)

// static fields belong to a class (as opposed to an object) and are not serialized
// use the keyword 'transient' to ignore class fields during serialization

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private Person person; // serializable attribute
    private transient Address address; // un-serializable attribute

    // getters and setters
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Overriding writeObject() and readObject() methods
    private void writeObject(ObjectOutputStream oos)
            throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(address.getHouseNumber());
    }

    private void readObject(ObjectInputStream ois)
            throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        Integer houseNumber = (Integer) ois.readObject();
        Address a = new Address();
        a.setHouseNumber(houseNumber);
        this.setAddress(a);
    }

    @Override
    public String toString() {
        return "Employee [person name = " + person.getName() + ", house number = " + address.getHouseNumber() + "]";
    }

}

class Address {
    private int houseNumber;

    // getters and setters
    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
}

public class CustomSerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p = new Person();
        p.setAge(18);
        p.setName("Preveen");

        Address a = new Address();
        a.setHouseNumber(1);

        Employee e = new Employee();
        e.setPerson(p);
        e.setAddress(a);

        File f = new File("details.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(e);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee e1 = (Employee) ois.readObject();
        ois.close();
        System.out.println(e1);

        // for assertions,use -ea flag in "java (-ea) classname" to enable assertions
        // comparing the state values before & after serialization:
        assert e1.getPerson().getAge() == e.getPerson().getAge() : "Age mismatch";
        assert e1.getAddress().getHouseNumber() == e.getAddress().getHouseNumber() : "House number mismatch";
    }
}