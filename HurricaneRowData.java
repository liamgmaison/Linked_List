/*
Title: HurricaneRowData.java
Name: William Maison-Bush
Date: 20 March 2025
Purpose: 
Sources: 
Java - How to Program - Late Objects 11th Edition (Deitel et al)
*/

/*
We need to make sure that HurricaneRowData objects can compare to other HRD
objects. So we will implement the sorting method.
*/

public class HurricaneRowData implements Comparable<HurricaneRowData> {
    
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
    
    // Override compareTo() from the implementation of Comparable. We need it
    // to be able to compare an input data point with another. This will be
    // important in sorting later.
    @Override
    public int compareTo(HurricaneRowData other)
    {
        return Integer.compare(other.aceIndex, this.aceIndex);
    } // End of compareTo
    
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
    }
    
} // End of class