/*
Title: Main.java
Name: William Maison-Bush
Date: 20 March 2025
Purpose: 
Sources: 
Java - How to Program - Late Objects 11th Edition (Deitel et al)
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedSortedList data = new DoublyLinkedSortedList();
        
        // Read data from ace.csv and insert it into the list
        try (Scanner scanner = new Scanner(new File("ace.csv"))) {
            scanner.nextLine(); // Skip header row if one exists
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                if (line.length < 5) continue; // Ensure proper format
                
                int year = Integer.parseInt(line[0].trim());
                int ace = Integer.parseInt(line[1].trim());
                int totalStorms = Integer.parseInt(line[2].trim());
                int hurricanes = Integer.parseInt(line[3].trim());
                int majorHurricanes = Integer.parseInt(line[4].trim());
                
                // Create HurricaneRowData with all 5 integer values
                data.add(new HurricaneRowData(year, ace, totalStorms, hurricanes, majorHurricanes));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        }
        
        // Get the hurricane with the maximum ACE value (first in sorted order)
        HurricaneRowData maxData = data.getFirst();
        if (maxData != null) {
            System.out.println("Year of max ace: " + maxData.getYear());
        } else {
            System.out.println("No hurricane data found.");
        }
        
        // Print all hurricanes sorted by ACE
        System.out.println("All data in order of Ace:");
        //HurricaneRowData.printHeader();
        System.out.println(data);
    }
}