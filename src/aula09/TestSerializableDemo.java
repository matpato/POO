package aula09;
import java.io.*;
/**
 * Case Study: Serializable object
 *
 *  Note − When serializing an object to a file, the standard convention
 *  in Java is to give the file a .ser extension.
 *
 An array is serializable if all its elements are serializable
 * Steps:
 * 1. Create an
 * a. ObjectOutputStream to write data into the file
 * 2. A string, double and an object are written to the file
 * 3. To improve performance you may add a buffer in the stream
 * <p>
 * author: matilde pato
 * date: 24 April 2018
 * lecture: 30 April 2018
 */
public class TestSerializableDemo {
    public static void main(String[] args){
        Employee e = new Employee();
        e.name = "Kim";
        e.address = "Lisbon, Portugal";
        e.ISSN = 99999999;
        e.number = 1111;

        try{
            FileOutputStream fileOut = new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in employee.ser");

        }catch(IOException ex){
            ex.printStackTrace();
        }

        e = null;
        try{
            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee)in.readObject();
            in.close();
            fileIn.close();
        }catch (IOException ex){
            ex.printStackTrace();
        } catch(ClassNotFoundException ex){
            System.out.print("Employee class not found");
            ex.printStackTrace();
        }
        System.out.println("Deserialized employee:");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("ISSN: " + e.ISSN);
        System.out.println("Number: " + e.number);
    }

}
class Employee implements java.io.Serializable{
    public String name;
    public String address;
    public transient int ISSN;
    public int number;

    public void mailCheck(){
        System.out.print("Mailing to check: " + name + " " + address);
    }

}