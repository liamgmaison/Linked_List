/*
Title: DoublyLinkedSortedList.java
Name: William Maison-Bush
Date: 20 March 2025
Purpose: 
Sources: 
Java - How to Program - Late Objects 11th Edition (Deitel et al)
*/

/*
We will be passing the methods of DoublyLinked...Interface into this class.
*/

public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        HurricaneRowData data;
        Node next;
        Node prev;

        Node(HurricaneRowData data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedSortedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(HurricaneRowData value) {
        Node newNode = new Node(value);

        if (head == null) { 
            head = tail = newNode;
        } else {
            Node current = head;
            while (current != null && current.data.getAceIndex() > value.getAceIndex()) { // Fixed comparison (descending order)
                current = current.next;
            }

            if (current == head) { 
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (current == null) { 
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else { 
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    @Override
    public boolean remove(HurricaneRowData value) {
        Node current = head;

        while (current != null) {
            if (current.data.equals(value)) {
                if (current == head) { 
                    head = current.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) { 
                    tail = current.prev;
                    if (tail != null) tail.next = null;
                } else { 
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(HurricaneRowData value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public HurricaneRowData getFirst() {
        return (head != null) ? head.data : null;
    }

    @Override
    public HurricaneRowData getLast() {
        return (tail != null) ? tail.data : null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
}