package aula09;

import java.io.*;
/**
 * Case Study: DataInputStream/DataOutputStream
 * DataInputStream reads bytes from the stream and converts them
 * into appropriate primitive-type values or strings.
 * DataOutputStream converts primitive-type values or strings
 * into bytes and outputs the bytes to the stream.

 * E.g.: A string, a double value, and an object are written
 * author: matilde pato
 * date: 24 April 2018
 * lecture: 30 April 2018
 */

public class TestDataStream {
    public static void main(String[] args) throws IOException {
        try (// create an output stream for file temp.dat
             DataOutputStream output = new DataOutputStream(
                     new FileOutputStream("temp.dat"))
        ) {
            //write student test scores to the file
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
        }
        try (//create an input stream for file temp.dat
             DataInputStream input = new DataInputStream((
                     new FileInputStream("temp.dat")
                     )) ){
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }
}

/**
 * If you keep reading data at the end of an InputStream, an EOFException will
 * occur. This exception can be used to detect the end of a file
 *
 * The program writes double and String values to the file using DataOutputStream
 * and reads the data using DataInputStream. When reading past the end of the
 * file, an EOFException is thrown
* */

class DetectEndOfFile{
    public static void main(String[] args) throws IOException {
        try (// create an output stream for file temp.dat
             DataOutputStream output = new DataOutputStream(
                     new BufferedOutputStream(
                     new FileOutputStream("temp.dat")))
        ) {
            //write student test scores to the file
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
        }
        try (//create an input stream for file temp.dat
             DataInputStream input = new DataInputStream((
                     new BufferedInputStream(
                     new FileInputStream("temp.dat")
             ))) ){
            while(true)
                System.out.println(input.readUTF() + " " + input.readDouble());
        }
        catch(EOFException ex){
            System.out.println("All data were read");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}