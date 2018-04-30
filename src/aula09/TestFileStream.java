package aula09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Case Study: FileInputStream/FileOutputStream is for
 * reading/writing bytes from/to files
 * Uses binary I/O to write ten byte values from 1 to
 * 10 to a file named temp.dat and reads them back from
 * the file.

 * <p>
 * author: matilde pato
 * date: 24 April 2018
 * lecture: 30 April 2018
 */
public class TestFileStream {
    public static void main(String[] args) throws IOException{
        try (
            //create an output stream to the file
            //root directory for the file is the classpath directory
            FileOutputStream output = new FileOutputStream("temp.dat")
        ){
            //output values to the file
            for(int i = 1; i <= 10; i++) output.write(i);
        }

        try(
                //create an input stream for the file
                FileInputStream input = new FileInputStream("temp.dat")
                ){
            //Read values from the file
            int value;
            while((value = input.read())!=-1)
                System.out.print(value + " ");
        }
    }
}
