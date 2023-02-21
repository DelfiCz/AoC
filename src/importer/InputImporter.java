package importer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * A wrapper for BufferedReader
 */
public class InputImporter extends BufferedReader {
    public InputImporter(String fileName) throws FileNotFoundException {
        super(new FileReader(fileName));
    }

    /**
     * Reads a line from the file. On EOF, returns null.
     * @return the line read, or null on EOF
     */
    public String readLine() {
        try {
            return super.readLine();
        } catch (Exception e) {
            return null;
        }
    }
}

