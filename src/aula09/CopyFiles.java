package aula09;

import java.io.*;

/**
 * Case Study: a useful utility for copying files.
 * User provide a source file and a target file as command-line
 * arguments using the command:
 *              java CopyFiles source target
 * <p>
 * The program copies the source file to the target and displays
 * the number os bytes in the file. The program should alert the
 * user if the source file does not exist or if the target file
 * already exists
 * <p>
 * Steps:
 * 1. Create an
 *      a. InputFileStream for the source file and an
 *      b. OutputFileStream for the target file
 * 2. Use BufferedInputStream and BufferedOutputStream to improve
 * the performance
 *
 * author: matilde pato
 * date: 24 April 2018
 * lecture 30 April 2018
 */
public class CopyFiles {
    /*Main method
    @param args[0] for source file
    @param args[1] for target file
    * */
    public static void main(String[] args) throws IOException {
        //Check command-line parameter usage
        if (args.length != 2) {
            System.out.println("Usage: java CopyFiles sourceFile targetFile");
            System.exit(1);
        }

        //Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] +
                    " does not exist.");
            System.exit(2);
        }

        //Check if target file exists
        File targetFile = new File(args[1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + args[1] +
                    " already exists.");
            System.exit(3);
        }

        try (
                //Create an input stream
                BufferedInputStream input = new BufferedInputStream(
                        new FileInputStream(sourceFile));
                //create an output stream
                BufferedOutputStream output = new BufferedOutputStream(
                        new FileOutputStream(targetFile))
        ) {
            //Continuously read a byte from input and write it to output
            int r, numberOfBytesCopied = 0;
            while ((r = input.read()) != -1) { //-1 signifies the end of file
                output.write((byte) r);
                numberOfBytesCopied++;
            }
            //Display the file size
            System.out.println(numberOfBytesCopied + " bytes copied");
        }

    }
}
