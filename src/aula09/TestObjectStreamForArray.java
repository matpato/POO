package aula09;

import java.io.*;

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

class TestObjectStreamForArray {
    public static void main(String[] args) throws
            ClassNotFoundException, IOException {
        int[] numbers = {1, 2, 3, 4, 5};
        String[] str = {"John", "Susan", "Kim"};

        try (//Create an output stream for file array.dat
             ObjectOutputStream output = new ObjectOutputStream(
                     new BufferedOutputStream(
                             new FileOutputStream("array.dat", true)
                     )
             )) {
            //Write arrays to the object output stream
            output.writeObject(numbers);
            output.writeObject(str);
        }

        try (// Create an input stream for file array.dat
             ObjectInputStream input = new ObjectInputStream(
                     new BufferedInputStream(
                             new FileInputStream("array.dat")
                     )
             )) {
            int[] newNumbers = (int[]) (input.readObject());
            String[] newStr = (String[]) (input.readObject());
            //Display arrays
            for (int n : newNumbers)
                System.out.print(n + " ");
            System.out.print("\n");

            for (String s : newStr)
                System.out.print(s + " ");
        }
    }

}