package aula09;

import java.io.*;

/**
 * Case Study: read/write serializable objects
 * 1. DataInputStream/DataOutputStream enables you to perform
 * I/O for primitive-type values and strings
 * 2. ObjectInputStream/ObjectOutputStream enables you to
 * perform I/O for objects in addition to primitive-type values
 * and strings
 * <p>
 * Steps:
 * 1. Create an
 * a. ObjectOutputStream to write data into the file
 * 2. A string, double and an object are written to the file
 * 3. To improve performance you may add a buffer in the stream
 * <p>
 * author: matilde pato
 * date: 24 April 2018
 * lecture 30 April 2018
 */
public class TestObjectOutputStream {
    public static void main(String[] args) throws IOException {
        try (
                //Create an output stream for file object.dat
                ObjectOutputStream output = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("object.dat")))
        ) {
            //Write a string, double value, and object to the file
            output.writeUTF("John");    //student name
            output.writeDouble(85.5);   //scores
            output.writeObject(new java.util.Date());//current date
        }
    }
}

class TestObjectInputStream{
    public static void main(String[] args)
            throws ClassNotFoundException, IOException{
        try (
            //Create an input stream for file object.dat
            ObjectInputStream input = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("object.dat")
                    )
            )
        ){//Read a string, double value, and object from the file
            String name = input.readUTF();
            double score = input.readDouble();
            // 1. readObject() may throw java.lang.ClassNotFoundException
            // because JVM restores an object, it first loads the class for
            // the object if the class has not been loaded
            // 2. since readObject() returns an Object it is cast into Date
            java.util.Date date = (java.util.Date)(input.readObject());
            System.out.println(name + " " + score + " " + date);
        }
//        catch(ClassNotFoundException ex1){
//            System.out.println("Class not found!");
//        }
        catch(EOFException ex2){
            System.out.println("All data were read");
        }
    }
}
