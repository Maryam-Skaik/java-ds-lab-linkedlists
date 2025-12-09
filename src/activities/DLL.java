/*
 * Activity 03: Swap Two Nodes in a Doubly Linked List (DLL)
 *
 * Objective:
 * Students must implement a function that swaps the positions of
 * TWO EXISTING nodes in a DLL WITHOUT swapping their data.
 *
 * Key idea:
 * We swap pointers (next/prev) instead of values.
 * This is more efficient when nodes store large objects.
 */

package linkedlist.activities;

public class DLL<T> {

    public Node<T> head;
    public Node<T> tail;
    int size;

    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }

    // Node class used in the DLL
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

    // Insert a node at the beginning
    public void insertAtHead(Node<T> node) {
        if (head == null) {
            head = tail = node;
            size++;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    // Insert a node at the end
    public void insertAtTail(Node<T> node) {
        if (tail == null) {
            head = tail = node;
            size++;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    /*
     * Activity 03: swapNodes(Node x, Node y)
     *
     * Implementation notes:
     * - Must handle 4 possible cases:
     *      1) x is head
     *      2) y is head
     *      3) x is tail
     *      4) y is tail
     * - Must rewire prev/next pointers of surrounding nodes
     * - Then swap internal pointers of x and y
     */
    public void swapNodes(Node x, Node y) {

        if (x == null || y == null) return;
        if (x == y) return;

        // Fix PREVIOUS pointers for x and y
        if (x.prev != null)
            x.prev.next = y;       // Normal case
        else
            head = y;              // x was the head → y becomes head

        if (y.prev != null)
            y.prev.next = x;
        else
            head = x;              // y was the head → x becomes head

        // Fix NEXT pointers for x and y
        if (x.next != null)
            x.next.prev = y;
        else
            tail = y;              // x was tail → y becomes tail

        if (y.next != null)
            y.next.prev = x;
        else
            tail = x;              // y was tail → x becomes tail

        // Now swap the internal pointers of x and y
        Node prev = x.prev;
        Node next = x.next;

        x.prev = y.prev;
        x.next = y.next;

        y.prev = prev;
        y.next = next;
    }

    // Forward traversal
    public void TraverseForward() {
        Node<T> currentNode = head;

        System.out.print("NULL <-> ");
        while (currentNode != null) {
            System.out.print(currentNode.element + " <-> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    // Backward traversal
    public void TraverseBackward() {
        Node<T> currentNode = tail;

        System.out.print("NULL <-> ");
        while (currentNode != null) {
            System.out.print(currentNode.element + " <-> ");
            currentNode = currentNode.prev;
        }
        System.out.println("NULL");
    }
}
