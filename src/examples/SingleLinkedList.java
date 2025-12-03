package java.ds.lab.linkedlists.examples;

/**
 * A basic implementation of a Single Linked List (SLL).
 * Each node points ONLY to the next node.
 * 
 * Educational purpose: DS Lab – Linked Lists.
 * Based on standard linked list behavior described in
 * Oracle Java SE API docs.
 * (Reference: https://docs.oracle.com/javase/8/docs/api/)
 */
/**
 *
 * @author Maryam
 */

public class SingleLinkedList<T> {

    // Pointer to the first node in the list
    public Node<T> head;

    // Constructor: initializes an empty list
    public SingleLinkedList() {
        head = null;
    }

    /**
     * Node class (static nested class).
     * Represents a single node in the linked list.
     * Stores:
     *  - element (data)
     *  - next pointer
     */
    public static class Node<T> {
        private T element;     // Data stored in node
        private Node<T> next;  // Pointer to next node

        public Node(T e, Node<T> n) {
            element = e;
            next = n;
        }

        public Node(T e) {
            element = e;
            next = null;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> n) {
            next = n;
        }
    }

    /**
     * Insert a node at the beginning of the list.
     * Time complexity: O(1)
     */
    public void insertAtHead(Node<T> node) {
        node.next = head; // Link new node to old head
        head = node;      // Update head
    }

    /**
     * Insert a node at the end of the list.
     * Time complexity: O(n)
     */
    public void insertAtTail(Node<T> node) {
        if (head == null) {
            insertAtHead(node);
            return;
        }

        Node<T> currentNode = head;

        // Traverse to last node
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = node; // Attach new node
    }

    /**
     * Deletes the first node containing the given element.
     * Time complexity: O(n)
     */
    public void deleteByValue(T element) {
        if (head == null) return;

        // If deleting the head
        if (head.element.equals(element)) {
            head = head.next;
            return;
        }

        Node<T> currentNode = head;

        // Search for node BEFORE the target
        while (currentNode.next != null &&
               !currentNode.next.element.equals(element)) {
            currentNode = currentNode.next;
        }

        // If found, skip the node to delete
        if (currentNode.next != null) {
            currentNode.next = currentNode.next.next;
        }
    }

    /**
     * Prints linked list nodes from head → NULL.
     * Example: 10 -> 20 -> 30 -> NULL
     */
    public void printList() {
        Node<T> currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.element + " -> ");
            currentNode = currentNode.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        SingleLinkedList<Integer> sll = new SingleLinkedList<>();

        sll.insertAtHead(new Node<>(10)); // List: 10
        sll.insertAtHead(new Node<>(20)); // List: 20 → 10
        sll.printList();

        sll.insertAtTail(new Node<>(30)); // 20 → 10 → 30
        sll.insertAtTail(new Node<>(40)); // 20 → 10 → 30 → 40
        sll.printList();

        sll.deleteByValue(30); // 20 → 10 → 40
        sll.printList();

        sll.deleteByValue(20); // 10 → 40
        sll.printList();

        sll.deleteByValue(7);  // Value not found → no change
        sll.printList();
    }
}