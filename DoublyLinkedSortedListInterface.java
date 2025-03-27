/*
Title: DoublyLinkedSortedListInterface.java
Name: William Maison-Bush
Date: 20 March 2025
Purpose: Defines the abstract methods for a generic doubly linked list that 
stores HurricaneRowData in sorted order.
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

/*
A quick reminder that an interface is like a contract and that all classes
will inherit from this set of methods that will be programmed with overrides.
*/

/* I had to simplify and remake this interface from the provided interface file.
*/

// Creates an interface called DoublyLinkedSortedListInterface
public interface DoublyLinkedSortedListInterface {
    
    // Adds a HurricaneRowData object  into the doubly linked list but
    // also will implement a method to move through the list, compare each
    // ace index value, and insert the data as a node in the node chain.
    void add(HurricaneRowData value);
    
    // Removes a HurricaneRowData object from the doubly linked list. Returns
    // a true Boolean if the process has completed.
    boolean remove(HurricaneRowData value);
    
    // Returns a Boolean true if the linked list contains the value. 
    boolean contains(HurricaneRowData value);
    
    // Returns the first element in the linked list
    HurricaneRowData getFirst();
    
    // Returns the last element in the linked list.
    HurricaneRowData getLast();
    
    // Returns the number of elements in the linked list.
    int size();
    
    // Returns the Boolean ture if the linked list is empty.
    boolean isEmpty();
    
} // End of DoublyLinkedSortedListInterface