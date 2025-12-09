package linkedlist.activities;

/**
 * Activity 04 — Circular Linked List (CLL) with basic operations
 *
 * Implemented operations:
 *  - insertAtHead(Node node)
 *  - insertAtTail(Node node)
 *  - deleteByValue(T element)
 *  - traverse()
 *
 * Key points and edge-cases:
 *  - CLL forms a cycle; the last node.next points to head.
 *  - Single-node list: node.next == node — must be handled specially on deletes.
 *  - traverse() must check for empty list before iterating.
 *  - After deletion of head, replace head's data with head.next (fast head deletion trick) when appropriate.
 */
public class CLL<T> {

    private Node<T> head;

    public CLL() {
        head = null;
    }

    public static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T e) {
            element = e;
            next = null;
        }

        public T getElement() { return element; }
        public Node<T> getNext() { return next; }
        public void setNext(Node<T> n) { next = n; }
    }

    // insert at head — O(n) with current approach (could be O(1) if tail pointer kept)
    public void insertAtHead(Node<T> node){
        if(head == null){
            head = node;
            head.next = head;
            return; // early return for empty-list case
        }

        // find last node so we can link it to the new head
        Node<T> currentNode = head;
        while(currentNode.next != head){
            currentNode = currentNode.next;
        }

        currentNode.next = node;
        node.next = head;
        head = node;
    }

    // insert at tail — O(n) (could be O(1) with tail pointer)
    public void insertAtTail(Node<T> node){
        if(head == null){
            head = node;
            head.next = head;
            return; // early return
        }

        Node<T> currentNode = head;
        while(currentNode.next != head){
            currentNode = currentNode.next;
        }

        currentNode.next = node;
        node.next = head;
    }

    // delete by value
    public void deleteByValue(T element){
        if(head == null) return;

        // Single-node list
        if(head.next == head){
            if (head.element.equals(element)) {
                head = null;
            }
            return;
        }

        // If head contains the element: copy next's data into head and remove next node (fast trick).
        if(head.element.equals(element)){
            head.element = head.next.element;
            head.next = head.next.next;
            return;
        }

        Node<T> currentNode = head;
        while(currentNode.next != head){
            if(currentNode.next.element.equals(element)){
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    // traverse all nodes and print elements (safely handle empty list)
    public void traverse(){
        if(head == null){
            System.out.println("(empty)");
            return;
        }

        Node<T> currentNode = head;
        do{
            System.out.print(currentNode.element + " ,");
            currentNode = currentNode.next;
        }while(currentNode != head);

        System.out.println();
    }

    public static void main(String[] args) {
        CLL<Character> cll = new CLL<>();
        cll.insertAtHead(new Node<>('A'));
        cll.insertAtHead(new Node<>('B')); // B A

        cll.traverse();

        cll.insertAtTail(new Node<>('C'));
        cll.insertAtTail(new Node<>('D')); // B A C D

        cll.traverse();

        cll.deleteByValue('C');

        cll.traverse();

        cll.deleteByValue('B');

        cll.traverse();
    }
}
