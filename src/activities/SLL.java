package linkedlist.activities;

/**
 * Activity 01 — Count nodes in a Singly Linked List (SLL)
 * Activity 02 — Print the Nth node from the end in a SLL
 *
 * Solutions included:
 *  - Counting nodes (approach A): traverse the list and count nodes (countNodes()).
 *  - Counting nodes (approach B): maintain a `size` attribute updated on insert/delete (size()).
 *  - Print Nth from end (approach A): use `size` and traverse to index (size - k).
 *  - Print Nth from end (approach B): two-pointer technique (nthNodeFromEnd) — one pointer is advanced k steps,
 *    then move both together until the first reaches the end; the second points to the desired node.
 *
 * Notes / edge-cases:
 *  - Deletion should only decrement size when a node is actually removed; code below ensures that.
 *  - Methods check for invalid k (k <= 0 or k > size) and return null in those cases.
 */
public class SLL<T> {

    public Node<T> head;
    private int size;

    public SLL() {
        head = null;
        size = 0;
    }

    public static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T e, Node<T> n) {
            element = e;
            next = n;
        }

        public Node(T e) {
            element = e;
            next = null;
        }

        public T getElement() { return element; }
        public Node<T> getNext() { return next; }
        public void setNext(Node<T> n) { next = n; }
    }

    /**
     * Insert at head — O(1)
     * - link new node to current head, update head, increment size.
     */
    public void insertAtHead(Node<T> node) {
        node.next = head;
        head = node;
        size++;
    }

    /**
     * Insert at tail — O(n)
     * - if empty, reuse insertAtHead (keeps size logic in one place).
     */
    public void insertAtTail(Node<T> node) {
        if (head == null) {
            insertAtHead(node);
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = node;
        size++;
    }

    /**
     * Delete first occurrence of `element`.
     * - Handles deletion of head, middle or tail node.
     * - Only decrements size when deletion actually happens.
     */
    public void deleteByValue(T element) {
        if (head == null) return;

        // Special-case: head contains the element
        if (head.element.equals(element)) {
            head = head.next;
            size--;
            return;
        }

        Node<T> currentNode = head;
        // Find node whose next contains the element
        while (currentNode.next != null &&
               !currentNode.next.element.equals(element)) {
            currentNode = currentNode.next;
        }

        // If found, unlink it and decrement size
        if (currentNode.next != null) {
            currentNode.next = currentNode.next.next;
            size--;
        }
    }

    /**
     * printList — O(n)
     */
    public void printList() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.element + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    /**
     * countNodes() — O(n)
     * - A traversal-based approach (Activity 01, approach A)
     * - Useful when you don't maintain a `size` field.
     */
    public int countNodes(){
        Node<T> currentNode = head;
        int count = 0;
        while(currentNode != null){
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    /**
     * size() — O(1)
     * - Returns maintained size (Activity 01, approach B).
     * - This is fast but requires you to correctly update `size` on every mutation.
     */
    public int size(){
        return size;
    }

    /**
     * printNthFromEnd(k) — using size()
     * Approach: compute index from head = size - k, traverse to it and return element.
     * Returns null for invalid k (k <= 0 or k > size).
     */
    public T printNthFromEnd(int k){
        if(k > size || k <= 0) return null;
        int idx = size - k; // 0-based index from head
        Node<T> currentNode = head;
        for(int i = 0; i < idx; i++){
            currentNode = currentNode.next;
        }
        return currentNode == null ? null : currentNode.element;
    }

    /**
     * nthNodeFromEnd(k) — two-pointer technique (O(n), single pass)
     * Steps:
     *  1. Advance `first` by k steps.
     *  2. Move `first` and `second` together until `first` becomes null.
     *  3. `second` points to the kth node from the end.
     *
     * Returns null for invalid k.
     */
    public T nthNodeFromEnd(int k){
        if(k > size || k <= 0) return null;

        Node<T> first = head;
        Node<T> second = head;

        // move first k steps ahead
        for(int i = 0; i < k; i++){
            if (first == null) return null; // safety
            first = first.next;
        }

        // move both until first reaches end
        while(first != null){
            first = first.next;
            second = second.next;
        }

        return second == null ? null : second.element;
    }

    public static void main(String[] args) {
        SLL<Integer> sll = new SLL<>();
        sll.insertAtHead(new Node<>(5));
        sll.insertAtHead(new Node<>(1));
        sll.insertAtHead(new Node<>(6));
        sll.insertAtHead(new Node<>(20)); // list: 20 -> 6 -> 1 -> 5

        sll.printList();
        System.out.println("countNodes() = " + sll.countNodes()); // 4
        System.out.println("size() = " + sll.size()); // 4

        System.out.println("2nd from end (by size): " + sll.printNthFromEnd(2)); // 1
        System.out.println("2nd from end (two-pointer): " + sll.nthNodeFromEnd(2)); // 1
    }

}
