/*
Title: DoublyLinkedSortedListInterface.java
Name: William Maison-Bush
Date: 20 March 2025
Purpose: 
Sources: 
Java - How to Program - Late Objects 11th Edition (Deitel et al)
*/

/*
A quick reminder that an interface is like a contract and that all classes
will inherit from this set of methods that will be programmed with overrides.
*/

public interface DoublyLinkedSortedListInterface {
    void add(HurricaneRowData value);
    boolean remove(HurricaneRowData value);
    boolean contains(HurricaneRowData value);
    HurricaneRowData getFirst();
    HurricaneRowData getLast();
    int size();
    boolean isEmpty();
}