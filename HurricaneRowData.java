/*
Title: HurricaneRowData.java
Name: William Maison-Bush
Date: 20 March 2025
Purpose: Stores and manages individual rows of hurricane data for sorting, 
comparison, and display.
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

// Implements Comparable so that objects of the HurricaneRowData class can be
// sorted using compareTo() method
public class HurricaneRowData implements Comparable<HurricaneRowData> {
    
    // Private instance variables declaration for use only in this class
    private int year;
    private int aceIndex;
    private int numOfTropicalStorms;
    private int numOfHurricanes;
    private int numOfMjrHurricanes;
    
    // Constructor
    public HurricaneRowData(int year, int aceIndex, int numOfTropicalStorms, 
        int numOfHurricanes, int numOfMjrHurricanes) {
            
            this.year = year;
            this.aceIndex = aceIndex;
            this.numOfTropicalStorms = numOfTropicalStorms;
            this.numOfHurricanes = numOfHurricanes;
            this.numOfMjrHurricanes = numOfMjrHurricanes;
            
        } // End of constructor
    
    // Getters
    // Reminder: We do this so that the private vars can be accessed outside
    // this class.
    public int getYear() {
        return year;
    }
    
    public int getAceIndex() {
        return aceIndex;
    }
    
    public int getnumOfTropicalStorms() {
        return numOfTropicalStorms;
    }
    
    public int getnumOfHurricanes() {
        return numOfHurricanes;
    }
    
    public int getnumOfMjrHurricanes() {
        return numOfMjrHurricanes;
    } // End of getters
    
    // Override toString() with example taken from Painting.java 
    // from 110_painting_example_overload_vs_override from 2251
    @Override
    public String toString() {
        return String.format("%10d %10d %10d %10d %10d", year, aceIndex, 
            numOfTropicalStorms, numOfHurricanes, numOfMjrHurricanes);
    } // End of toString() method
    
    // This prints column headers for the output, but we are not using it but
    // I decided to keep it here anyway. 
    public static void printHeader() {
        System.out.printf("%10s %10s %10s %10s %10s%n",
            "Year", "ACE Index", "Tropical Storms", "Total Hurricanes", 
            "Major Hurricanes");
    } // End of printHeader() method
    
    // Override compareTo() from the implementation of Comparable. We need it
    // to be able to compare an input data point with another. This will be
    // important in sorting later.
    @Override
    public int compareTo(HurricaneRowData other)
    {
        return Integer.compare(other.aceIndex, this.aceIndex);
    } // End of compareTo() method
    
    // Override of equals() method to ensure identity of a HRD object.
    @Override
    public boolean equals(Object obj)
    {
        // This checks if this object and obj are equal
        if (this == obj) {
            return true;
        }
        // This checks if the obj is null OR if the class of the object is 
        // not the same as a HurricaneRowObject
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // This casts HurricaneRowData as a legit HRD object
        HurricaneRowData other = (HurricaneRowData) obj;
        
        // This returns true if all these fields match else it returns false
        return this.year == other.year &&
        this.aceIndex == other.aceIndex &&
        this.numOfTropicalStorms == other.numOfTropicalStorms &&
        this.numOfHurricanes == other.numOfHurricanes &&
        this.numOfMjrHurricanes == other.numOfMjrHurricanes;
    } // End of equals() method
    
} // End of class