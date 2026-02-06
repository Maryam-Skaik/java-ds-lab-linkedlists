package linkedlists.assignment_solutions;

/**
 * Problem:
 * Reverse a Singly Linked List (SLL).
 *
 * Approach:
 * - Use three pointers:
 *   prev    → previous node
 *   current → current node being processed
 *   next    → stores next node before breaking the link
 *
 * Algorithm:
 * - Traverse the list
 * - Reverse the direction of each next pointer
 * - Update head at the end
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ReverseSLL<T> {

    private Node<T> head;

    public void reverse() {

        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next;

        while (current != null) {

            // Save next node before breaking the link
            next = current.getNext();

            // Reverse the pointer
            current.setNext(prev);

            // Move pointers forward
            prev = current;
            current = next;
        }

        // Update head to the new first node
        head = prev;
    }
}
