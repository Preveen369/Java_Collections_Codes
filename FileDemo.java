import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileDemo {
    public static void main(String[] args) {
        try {
            // To handle teh file object:
            File f = new File("intro.txt");

            // To handle the file writing purpose:
            FileOutputStream fos = new FileOutputStream(f);
            DataOutputStream dos = new DataOutputStream(fos);
            // to write the text into the file of UTF char format
            dos.writeUTF("Welcome to this file");   
            dos.close();

            // To handle the file reading purpose:
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            // to read the text from the file of UTF char format
            String str = dis.readUTF();
            System.out.println(str);
            dis.close();
        } 
        catch (Exception e) {
            // Handle if FileNotFoundException occurs
            e.printStackTrace();
        }

    }
}