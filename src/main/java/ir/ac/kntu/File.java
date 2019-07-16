package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The type File.
 */
public class File {
    /**
     * Read file string.
     *
     * @return the string
     */
    public String ReadFile() {
        FileReader fR = null;
        BufferedReader bR = null;
        String tempInput = "";
        try {
            fR = new FileReader("C:" +
                    "\\Users\\ASUS\\Desktop\\GITHUB\\java-assignment" +
                    "\\HW5\\endgame\\endgame\\src\\ir\\ac\\kntu\\input.txt");
            bR = new BufferedReader(fR);
            String input;
            while ((input = bR.readLine()) != null) {
                tempInput += input;
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (bR != null) {
                    bR.close();
                }
                if (fR != null) {
                    bR.close();
                }
            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            } finally {
                return tempInput;
            }
        }
    }
}
