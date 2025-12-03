package java.ds.lab.linkedlists.examples;

/**
 * Basic implementation of a Double Linked List (DLL).
 * Each node contains:
 *   - element
 *   - next pointer
 *   - prev pointer
 *
 * Supports forward & backward traversal.
 * References: Oracle Java SE API docs for pointer-based structures
 * https://docs.oracle.com/javase/8/docs/api/
 */
/**
 *
 * @author Maryam
 */

public class DoubleLinkedList<T> {

    public Node<T> head; // First node
    public Node<T> tail; // Last node

    // Constructor: initializes empty list
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Node class for DLL.
     * Stores:
     *   - element
     *   - next link
     *   - prev link
     */
    public static class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(T e, Node<T> n, Node<T> p) {
            element = e;
            next = n;
            prev = p;
        }

        public T getElement() { return element; }
        public Node<T> getNext() { return next; }
        public Node<T> getPrev() { return prev; }
        public void setNext(Node<T> n) { next = n; }
        public void setPrev(Node<T> p) { prev = p; }
    }

    /**
     * Insert a new node at the head.
     * Time complexity: O(1)
     */
    public void insertAtHead(Node<T> node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    /**
     * Insert at the tail.
     * Time complexity: O(1)
     */
    public void insertAtTail(Node<T> node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    /**
     * Delete the first node containing the given element.
     * Cases:
     *   - delete head
     *   - delete tail
     *   - delete middle
     */
    public void deleteByValue(T element) {
        if (tail == null) return; // Empty list

        // Delete head
        if (head.element.equals(element)) {
            if (head == tail) { // One element only
                head = null;
                tail = null;
                return;
            }
            head = head.next;
            head.prev = null;
            return;
        }

        // Delete tail
        if (tail.element.equals(element)) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        // Delete middle node
        Node<T> currentNode = head;

        while (currentNode != null &&
               !currentNode.element.equals(element)) {
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }
    }

    /**
     * Traverse from head → tail.
     * Example output: NULL <-> 20 <-> 10 <-> NULL
     */
    public void TraverseForward() {
        Node<T> currentNode = head;

        System.out.print("NULL <-> ");

        while (currentNode != null) {
            System.out.print(currentNode.element + " <-> ");
            currentNode = currentNode.next;
        }

        System.out.println("NULL");
    }

    /**
     * Traverse from tail → head.
     */
    public void TraverseBackward() {
        Node<T> currentNode = tail;

        System.out.print("NULL <-> ");

        while (currentNode != null) {
            System.out.print(currentNode.element + " <-> ");
            currentNode = currentNode.prev;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();

        dll.insertAtHead(new Node<>(10, null, null)); // 10
        dll.insertAtHead(new Node<>(20, null, null)); // 20 10

        dll.TraverseForward();
        dll.TraverseBackward();

        dll.insertAtTail(new Node<>(30, null, null)); // 20 10 30
        dll.insertAtTail(new Node<>(40, null, null)); // 20 10 30 40

        System.out.println("-------------");
        dll.TraverseForward();
        dll.TraverseBackward();

        System.out.println("--------------");
        dll.deleteByValue(30); // 20 10 40
        dll.TraverseForward();

        dll.deleteByValue(20); // 10 40
        dll.TraverseForward();

        dll.deleteByValue(40); // 10
        dll.TraverseForward();

        dll.deleteByValue(50); // Not found
        dll.TraverseForward();
    }
}