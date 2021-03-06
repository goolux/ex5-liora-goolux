package filesprocessing;

import java.io.*;
import java.util.ArrayList;

/*
 * This class reads the text from the command file and saves it in an array list of Strings.
 * @author nlux, liorait.
 */
class CommandFile extends FileFacade {

   /*
    *  Creates a new CommandFile object
    */
    CommandFile(String s) {
        super(s);
    }

    /*
     * The method reads the file, and returns an arrayList containing all the lines in the file
     * @return the array list representing all the strings in the file
     */
    ArrayList<String> readFile() throws TypeTwoExceptions.IOProblemInCommandFile {
        ArrayList<String> fileData = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getAbsolutePath()))) {
            String line;
            int i = 0;
            // runs all over the file, while the file not over, and adds each line to the arrayList
            while ((line = bufferedReader.readLine()) != null) {
                fileData.add(i, line); // adds the current line to the arrayList in the next empty index
                i++; // Increases the iterator through the arrayList
            }
        } catch (IOException ioe) {
          throw new TypeTwoExceptions.IOProblemInCommandFile();
        }
        return fileData;
    } // end of readFile method
} // end of CommandFile class




