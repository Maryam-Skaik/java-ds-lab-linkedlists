package linkedlist.activities;

/**
 * Activity 03 — Swap two nodes in a Doubly Linked List (DLL)
 *
 * Approach used:
 *  - Rewire `prev` and `next` pointers of the two nodes and their neighbors.
 *  - Update head/tail if either node was at the boundary.
 *
 * Important notes:
 *  - Swapping nodes is pointer manipulation only; we do not swap node.element values.
 *  - Must handle cases when one or both nodes are head/tail.
 *  - Adjacent-node swap requires careful pointer updates; the implementation below is written
 *    to handle general cases (non-null checks / head/tail updates).
 *  - Deletion fixes: deleteByValue only decrements size when deletion occurs.
 */
public class DLL<T> {

    public Node<T> head;
    public Node<T> tail;
    private int size;

    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }

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

    public void insertAtHead(Node<T> node) {
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    public void insertAtTail(Node<T> node) {
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    public void deleteByValue(T element) {
        if (head == null) return;

        // delete head
        if (head.element.equals(element)) {
            if (head == tail) {
                head = null;
                tail = null;
                size--;
                return;
            }
            head = head.next;
            head.prev = null;
            size--;
            return;
        }

        // delete tail
        if (tail.element.equals(element)) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }

        Node<T> currentNode = head;
        while (currentNode != null && !currentNode.element.equals(element)) {
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            // unlink currentNode
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            size--;
        }
    }

    public void TraverseForward() {
        Node<T> currentNode = head;
        System.out.print("NULL <-> ");
        while (currentNode != null) {
            System.out.print(currentNode.element + " <-> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    public void TraverseBackward() {
        Node<T> currentNode = tail;
        System.out.print("NULL <-> ");
        while (currentNode != null) {
            System.out.print(currentNode.element + " <-> ");
            currentNode = currentNode.prev;
        }
        System.out.println("NULL");
    }

    public int size(){
        return size;
    }

    /**
     * swapNodes(x, y)
     * - Rewires neighbors and x,y next/prev references.
     * - Updates head/tail when needed.
     *
     * Important: This method avoids swapping element values and swaps node positions.
     * Handle x == y and null arguments early.
     */
    public void swapNodes(Node<T> x, Node<T> y){
        if(x == null || y == null) return;
        if(x == y) return;

        // If either node is head, update head pointer to the other node
        if(x.prev != null)
            x.prev.next = y;
        else
            head = y;

        if(y.prev != null)
            y.prev.next = x;
        else
            head = x;

        // If either node is tail, update tail pointer to the other node
        if(x.next != null)
            x.next.prev = y;
        else
            tail = y;

        if(y.next != null)
            y.next.prev = x;
        else
            tail = x;

        // swap x.prev/x.next with y.prev/y.next
        Node<T> prevX = x.prev;
        Node<T> nextX = x.next;

        x.next = y.next;
        x.prev = y.prev;

        y.prev = prevX;
        y.next = nextX;
    }

    public static void main(String[] args) {
        DLL<Integer> dll = new DLL<>();

        Node<Integer> a = new Node<>(1, null, null);
        Node<Integer> b = new Node<>(2, null, null);
        Node<Integer> c = new Node<>(3, null, null);
        Node<Integer> d = new Node<>(4, null, null);

        dll.insertAtHead(d);
        dll.insertAtHead(c);
        dll.insertAtHead(b);
        dll.insertAtHead(a); // 1 2 3 4

        dll.TraverseForward();

        System.out.println("------------");

        dll.swapNodes(a, d); // swap head and tail

        dll.TraverseForward();
    }
}
