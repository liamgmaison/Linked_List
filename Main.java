/*
Title: Main.java
Name: William Maison-Bush
Date: 20 March 2025
Purpose: To read hurricane data from a CSV file, store it in a sorted doubly 
linked list based on ACE index, and display the year with the highest ACE along
with all sorted hurricane records.
Sources: 
Java - How to Program - Late Objects 11th Edition (Deitel et al)
https://www.geeksforgeeks.org/doubly-linked-list/
https://www.programiz.com/dsa/doubly-linked-list
https://www.tutorialspoint.com/data_structures_algorithms/doubly_linked_list_algorithm.htm
https://en.wikipedia.org/wiki/Doubly_linked_list
https://www.codecademy.com/article/doubly-linked-list-conceptual
https://www.youtube.com/watch?v=k0pjD12bzP0 ￼
https://www.youtube.com/watch?v=-StYr9wILqo ￼
https://www.youtube.com/watch?v=K1NmSaKBpko ￼
https://www.youtube.com/watch?v=N6dOwBde7-M ￼
https://www.youtube.com/watch?v=58YbpRDc4yw 

*/

// We need file to access...uh files...
import java.io.File;
// We need IOException 
import java.io.IOException;
// We need Scanner to avoid the header and read the file
import java.util.Scanner;

// This is the main class. 
public class Main {
    
    public static void main(String[] args) {
        
        // We care creating a new DLSL called data that will store HRD objects.
        // Lowkey, I do not want to write out the full names. This links to 
        // DoublyLinkedSortedList that links to DoubleLinkedSortedInterface.
        DoublyLinkedSortedList data = new DoublyLinkedSortedList();
        
        // Read data from ace.csv and insert it into the list
        // I do not really know if I should do args to main with this one, but
        // I will leave it with ace.csv.
        try (Scanner scanner = new Scanner(new File("ace.csv"))) {
            
            //  This skips the header if it exists because we don't need that.
            scanner.nextLine();
            
            // Here starts the while loop that runs as long as the scanner 
            // says there is a next line.
            while (scanner.hasNextLine()) {
                
                // This splits each line according to commas.
                String[] line = scanner.nextLine().split(",");
                
                // This one was weird. It was throwing errors all day until I
                // looked up finally why this would not work. It works, but
                // it makes me uncomfortable. I read it as if the line.length
                // is less than 5, continue until it doesn't work.
                if (line.length < 5) continue;
                
                // These were stolen from the hurricane project and it is 
                // simply retrieving information accordingly. It is essential
                // to convert each piece of data from a String to an int.
                int year = Integer.parseInt(line[0].trim());
                int aceIndex = Integer.parseInt(line[1].trim());
                int numOfTropicalStorms = Integer.parseInt(line[2].trim());
                int hurricanes = Integer.parseInt(line[3].trim());
                int majorHurricanes = Integer.parseInt(line[4].trim());
                
                // We create a new HurricaneRowData object and add it to the
                // sorted list that we created.
                data.add(new HurricaneRowData(year, aceIndex, 
                    numOfTropicalStorms, hurricanes, majorHurricanes));
            } // End of while loop
            // I was advised reading data should always come with an error
            // exepction handling for when the file cannot be read.
        } catch (IOException e) {
            System.out.println("ERROR! Cannot read file: " + e.getMessage());
        } 
        
        // We are retrieivng the first hurricane entry and printing the year.
        // We are already assuming that the year has the highest ACE Index 
        // score because the list is already sorted. If there is no data,
        // we have a little error correction.
        HurricaneRowData maxData = data.getFirst();
        if (maxData != null) {
            System.out.println("Year of max ace: " + maxData.getYear());
        } else {
            System.out.println("ERROR! No hurricane data found!");
        }
        
        // We print out the data
        System.out.println("All data in order of Ace:");
        // Removed header to match output
        //HurricaneRowData.printHeader(); 
        System.out.println(data);
    } // End of Main
} // END END