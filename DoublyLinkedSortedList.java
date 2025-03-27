/*
Title: DoublyLinkedSortedList.java
Name: William Maison-Bush
Date: 20 March 2025
Purpose: Implements a sorted doubly linked list of HurricaneRowData entries 
with full insertion, removal, search, and traversal methods.
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
We will be passing the methods of DoublyLinked...Interface into this class.
*/

// This implements DoublyLinkedSortedListInterface and we will now have to 
// override all the methods that are declared in the interface.
public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {
    
    // We are creating the parameters that are necessary for the creation of 
    // the node class.
    // head is the first node in the linked list on initialization
    private Node head;
    // tail is the last node in the linked list on initialization
    private Node tail;
    // size is the number of nodes in the linked list
    private int size;

    // We create the node class which ensures that the data stored in the node
    // is HurricaneRowData definted as data, next that points to the next node,
    // and prev that points toward the previous node.
    private class Node {
        HurricaneRowData data;
        Node next;
        Node prev;
        
        // Constructor that initializes next and previous as null for the first
        // node. 
        Node(HurricaneRowData data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        } // End of constructor
    } // End of class Node
    
    // Constrcutor for an empty doubly-linked list that self-sorts
    public DoublyLinkedSortedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    } // End of constructor

    // Overrides the add() method. Inserts a new node and then moves through
    // the list to place the node in its appropriate spot using AceIndex as
    // the value of comparison. This is the meat and potatoes. It must be
    // protected at all costs.
    @Override
    public void add(HurricaneRowData value) {
        
        // Creates a new node with the hurricane data as value
        Node newNode = new Node(value);

        // If the list is empty (head == null), the new node will become its
        // own head and tail.
        if (head == null) { 
            head = newNode; 
            tail = newNode;
            // Otherwise, we will move node to node and compare to find where
            // the node should be placed using AceIndex as a comparison and
            // moving downstream.This is one of the most important parts of 
            // this overall program. This triggers when the list is not empty.
        } else {
            // We set a new node, current, and set it to the head. We will 
            // walk data through current. 
            Node current = head;
            
            // While current is not null, as in it has not reached the end yet
            // and the ace index of the current node is greater than the ace
            // index of the new node, we keep moving to the next node. If
            // current reaches the end, it will be the smallest ACE value. 
            // However, if we find a node with an ACE less than or equal to
            // the new value, we insert the node there.
            
            while (current != null && 
                current.data.getAceIndex() > value.getAceIndex()) {
                current = current.next;
            } // End of while loop

            // This is the insertion method with conditionals that control
            // how the value is inserted. After the while loop has found the
            // right placement for the data according to ace index. We insert
            // at the head and establish the connections.
            
            // Conditional for the highest ace index value and establishment
            // as the head of the entire linked list.
            if (current == head) { 
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                
                // Conditional for the lowest ace index value and establishment
                // as the tail of the entire linked list.
            } else if (current == null) { 
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                
                // The insertion of the data inside the list and is the most
                // general conditional for a value that is neither max or min.
            } else { 
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        // This is the size counter so we can maintain the linked list size.
        size++;
    } // End of the add() method

    // This method is to remove values from the linked list.
    @Override
    public boolean remove(HurricaneRowData value) {
        
        // Instantiate a new node named current and set it to the head of the
        // linked list.
        Node current = head;
        
        // This while look, like the add method, walks through the entire list
        // downstream. 
        while (current != null) {
            // If the value of question is found we remove that value and 
            // re-establish the links without the removed node.
            if (current.data.equals(value)) {
                // We uodate the head and re-connect if removing the head node
                // or max value 
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                // We update the tail and re-connect if removing the tail
                // node or min value
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                // Else we remmove a node in the middle of the list and
                // reconnect both next and previous.
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                // We reduce the size counter by one
                size--;
                // Returns true if the value was found
                return true;
            }
            // Walk walk walk
            current = current.next;
        } // End of while loop
        // If the value is not foudn, then we return false
        return false;
        
    } // End of remove() method
    
    // This overridden contains() method returns a boolean true or false
    @Override
    public boolean contains(HurricaneRowData value) {
        
        // Start from the head of the list and create a new node called...
        Node current = head;
        
        // Walk through the list until the end of the list is reached
        while (current != null) {
            // If the current node's data matches the given value, return true
            if (current.data.equals(value)) {
                return true;
            }
            // Move to the next node
            current = current.next;
        }
        // If we reach here, the value wasn't found
        return false;
    } // End of contains() method

    // This method returns data from the head node (first node in the list)
    // If the list is empty, it returns null
    @Override
    public HurricaneRowData getFirst() {
        return (head != null) ? head.data : null;
    }
    
    // This method returns data from the tail node (last node in the list)
    // If the list is empty, it returns null
    @Override
    public HurricaneRowData getLast() {
        return (tail != null) ? tail.data : null;
    }
    
    // This method returns the total number of nodes in the list
    @Override
    public int size() {
        return size;
    }
    
    // This method checks if the list is empty by seeing if size is 0
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    // This method builds a string of all the data in the list
    // It starts at the head and adds each node’s data to a StringBuilder
    @Override
    public String toString() {
        
        // Stores the string data
        StringBuilder sb = new StringBuilder();
        // Starts at the beginning of the list
        Node current = head;
        
        // Walk through the list until we reach the end
        while (current != null) {
            // Adds data
            sb.append(current.data).append("\n");
            // Move onto the next node
            current = current.next;
        } // End of While
        
        // Return the entire formatted string of all data
        return sb.toString();
    } // End of toString() method
    
} // END END