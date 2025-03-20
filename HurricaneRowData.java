/*
Title: HurricaneRowData.java
Name: William Maison-Bush
Date: 07 February 2025
Purpose: The purpose of this code is to define a data model (HurricaneRowData) 
that stores hurricane statistics for a given year, including the ACE 
Index, number of tropical storms, hurricanes, and major hurricanes, 
with methods to access and display this information in a structured 
format.
Sources: Java - How to Program - Late Objects 11th Edition Deitel et al
https://www.w3schools.com/java/java_class_methods.asp
2251 Example Files
ChatGPT: "Explain how to use classes using character building with a
Fallout 3-like system."
}"
*/

public class HurricaneRowData {
    
    // Private instance variables
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
        return "Year: " + year + ", ACE Index: " + aceIndex + 
        ", Tropical Storms: " + numOfTropicalStorms + 
        ", Hurricanes (Cat. 1-5): " + numOfHurricanes + 
        ", Major Hurricanes (Cat. 3-5): " + numOfMjrHurricanes;
    } // End of toString override
    
} // End of class