package aula09;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 * Case Study: Serializable interface
 * 1. Not every object can be written to an output stream.
 * Objects that can be so written are said to be serializable
 * Serializable object is an instance of the
 * java.io.Serializable interface, so object must implement
 * Serializable

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
public class TestSerializable {
    public static void main(String[] args) throws IOException{
        try(ObjectOutputStream output =
        new ObjectOutputStream(new FileOutputStream("array.dat"))){
            output.writeObject(new A());
        }
    }
//    private int v1; // is serializable
//    private static double v2; //not serializable because is static
//    private transient A v3 = new A(); //not serializable because is marked
//    // transient. If v3 were not marked transient, a
//    // java.io.NotSerializableException would occur.

}

class A implements java.io.Serializable{
    B b = new B();
}

class B { } //B is not serializable