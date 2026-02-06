package assignment_solutions;

/**
 * Problem:
 * Reorder a Doubly Linked List so that:
 * - All nodes with ODD values appear first
 * - Followed by nodes with EVEN values
 *
 * Important:
 * - This solution assumes the list stores Integer values.
 *
 * Approach:
 * - Traverse the list once
 * - Split nodes into two separate lists: odd-valued and even-valued
 * - Merge the two lists at the end
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class OddEvenDLL {

    private Node<Integer> head;
    private Node<Integer> tail;

    public void reorderOddEven() {

        if (head == null || head.getNext() == null) return;

        Node<Integer> oddHead = null, oddTail = null;
        Node<Integer> evenHead = null, evenTail = null;

        Node<Integer> current = head;

        while (current != null) {

            Node<Integer> next = current.getNext();

            // Detach current node completely
            current.setNext(null);
            current.setPrev(null);

            int value = current.getElement();

            if (value % 2 != 0) { // ODD
                if (oddHead == null) {
                    oddHead = oddTail = current;
                } else {
                    oddTail.setNext(current);
                    current.setPrev(oddTail);
                    oddTail = current;
                }
            } else { // EVEN
                if (evenHead == null) {
                    evenHead = evenTail = current;
                } else {
                    evenTail.setNext(current);
                    current.setPrev(evenTail);
                    evenTail = current;
                }
            }

            current = next;
        }

        // Merge odd list with even list
        if (oddTail != null) {
            oddTail.setNext(evenHead);
            if (evenHead != null) evenHead.setPrev(oddTail);
            head = oddHead;
            tail = (evenTail != null) ? evenTail : oddTail;
        } else {
            head = evenHead;
            tail = evenTail;
        }
    }
}
