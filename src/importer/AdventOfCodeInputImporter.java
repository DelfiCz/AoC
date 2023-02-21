package importer;

import java.io.FileNotFoundException;

/**
 * Imports input from file for Advent of Code. Year, day, and part are arguments for selecting the correct input file.
 */
public class AdventOfCodeInputImporter extends InputImporter {

    public AdventOfCodeInputImporter(int year, int day, int part) throws FileNotFoundException {
        super("input/" + year + "/" + day + "/input_" + part + ".txt");
    }
}
