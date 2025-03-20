/*
Title: Main.java
Name: William Maison-Bush
Date: 20 March 2025
Purpose: 
Sources: 
Java - How to Program - Late Objects 11th Edition (Deitel et al)
*/

import java.util.Scanner;
// We are storing the hurricane data objects into an array list
import java.util.ArrayList;
// This is needed to handle the file reading
import java.io.File;
// This is to write a file with the results
import java.io.FileWriter;
// This is to handle errors for when there is no file
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        // Create an ArrayList to store hurricane data objects
        // The objects in question are defined by the year
//      ArrayList<HurricaneRowData> hurricaneData = new ArrayList<>();
        // We are now using a linked list.
        DoublyLinkedSortedList data = new DoublyLinkedSortedList();
        
        // We use a try catch for exception handling
        try {
            // We are loading ace.csv as the file.
            File file = new File("ace.csv");
            // Scanner is used to actually read the data from the csv file
            Scanner scanner = new Scanner(file);
            
            // The first row does not have any data, just titles, so we need 
            // to ignore it. "How to input a csv and ignore titles." First 
            // checks if there is a second line, and if true, this skips the
            // title.
            scanner.nextLine();
            
            // A while loop is useful in looping until the file is completely
            // covered. The loop continues as long as there is a next line.
            while (scanner.hasNextLine()) {
                // Every row is read as they are considered lines separated by
                // commas...CSV
                String[] values = scanner.nextLine().split(",");
                
                // We now will take the data stored in values and trim out each
                // data value and turn it into an integer. These values are
                // stored into the arraylist using hurricaneData.add.
                hurricaneData.add(new HurricaneRowData(
                    // Year
                    Integer.parseInt(values[0].trim()),
                    // ACE Index
                    Integer.parseInt(values[1].trim()),
                    // Number of Tropical Storms
                    Integer.parseInt(values[2].trim()),
                    // Number of Hurricanes (Cat. 1-5)
                    Integer.parseInt(values[3].trim()),
                    // Number of Major Hurricanes (Cat. 3-5)
                    Integer.parseInt(values[4].trim())
                ));
            }
            
            // Closing the scanner since we are done reading the csv file.
            // Always close the scanner!
            scanner.close();
            
        } catch (IOException e) {
            // If there is an error reading the file, we notify the user
            System.out.println("Error! Can't read the file!");
            return;
        } // End of try-catch
        
        // Print the data stored by iterating through each object. The number
        // of objects stored in the arraylist is the value called by 
        // hurricaneData.size. This uses the overridden toString method in 
        // HurricaneRowData.java to print out each line with headings.
        for (int i = 0; i < hurricaneData.size(); i++) {
            System.out.println(hurricaneData.get(i));
        }
        
        // Find the year with the highest ACE index
        // We will be using these methods at the end of this program.
        int maxYear = findMaxACEYear(hurricaneData);
        int maxACE = findMaxACE(hurricaneData);
        
        // Print the results for the terminal!
        System.out.println("\nThe year with the maximum ACE index was " 
            + maxYear + " with the value " + maxACE + ".");
        
        // Write the result to a file in the same directory as these programs
        saveFile(maxYear, maxACE);
    }
    
    // This method finds the maximum ACE value.
    private static int findMaxACE(ArrayList<HurricaneRowData> data) {
        // We instantiate the variable maxACE with the initial value as index 0
        int maxACE = data.get(0).getAceIndex();
        
        // We find the maximum ACE value by checking each value i't' arraylist.
        // We check in the if statmement if the value of each iteration is 
        // greater than the maxACE, and if so, we store that value as maxACE
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).getAceIndex() > maxACE) {
                maxACE = data.get(i).getAceIndex();
            } // End of if statement
        } // End of for loop
        return maxACE; // Returns maxACE
    } // End of the findMaxACE
    
    // This method finds the year with the maximum ACE value.
    private static int findMaxACEYear(ArrayList<HurricaneRowData> data) {
        // We instantiate the variables with the initial value as index 0
        int maxYear = data.get(0).getYear();
        int maxACE = data.get(0).getAceIndex();
        
        // Now we find the maximum value by checking each value i't' arraylist.
        // We check in the if statmement if the value of each iteration is 
        // greater than the maxACE, and if so, we store that value as both
        // the maxACE variable and the maxYear tied to maxACE.
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).getAceIndex() > maxACE) {
                maxACE = data.get(i).getAceIndex();
                maxYear = data.get(i).getYear();
            } // End of if statement
        } // End of the for loop
        return maxYear; // Returns the maxYear
    } // End of the findMaxACEYear
    
    // This saves the data to an external file
    private static void saveFile(int maxYear, int maxACE) {
        try {
            // Uses FileWriter to create a new text file
            FileWriter shakespeare = new FileWriter("hurricane_output.txt");
            shakespeare.write("The year with the maximum ACE index was " 
                + maxYear + " with the value " + maxACE + ".");
            shakespeare.close();
            System.out.println("\n> Saved as hurricane_output.txt!");
        } catch (IOException e) {
            // If writing to the file fails, we notify the user
            System.out.println("Error! Cannot write the file!");
        } // End of try-catch for writing
    } // End of the saveFile method
    
}