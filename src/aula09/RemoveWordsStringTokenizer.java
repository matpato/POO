package aula09;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Case Study: Given two files input.txt and delete.txt.
 * Perform file extraction(Input-Delete) and save the output in
 * file say output.txt
 * Using: StringTokenizer
 * StringTokenizer class in Java is used to break a string into tokens
 * TODO: implement try-catch-block and use binary file instead of text
 * <p>
 * Steps:
 * 1. Create PrintWriter object for output.txt
 * 2. Open BufferedReader for input.txt
 * 3. Run a loop for each line of input.txt
 * 3.1 flag = false
 * 3.2 Open BufferedReader for delete.txt
 * 3.3 Run a loop for each line of delete.txt
 * ->  If  line of delete.txt is equal to current line of input.txt
 * -> flag = true
 * -> break loop
 * <p>
 * 4. Check flag, if false
 * -> write current line of input.txt to output.txt
 * 5. Flush PrintWriter stream and close resources.
 */

public class RemoveWordsStringTokenizer {
    public static void main(String[] args) throws IOException {
        // PrintWriter object for output.txt

        File file = new File("file.txt");
        File temp = File.createTempFile("file", ".txt", file.getParentFile());
        //Determine the charset.
        String charset = "UTF-8";
        //Determine the string you'd like to delete.
        String delete = "foo";

        try (BufferedReader reader = new BufferedReader(new
                InputStreamReader(new FileInputStream(file), charset));

             PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                     new FileOutputStream(temp), charset))
        ) {

            for (String line; (line = reader.readLine()) != null; ) {
                line = line.replace(delete, "");
                writer.println(line);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        temp.renameTo(file);
    }
}