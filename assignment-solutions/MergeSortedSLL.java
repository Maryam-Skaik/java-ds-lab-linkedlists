package assignment_solutions;

/**
 * Problem:
 * Merge two sorted Singly Linked Lists into one sorted list.
 *
 * Constraints:
 * - Lists are already sorted
 * - No new nodes should be created
 *
 * Approach:
 * - Use a dummy node to simplify pointer handling
 * - Reuse existing nodes
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */
public class MergeSortedSLL {

    public static <T extends Comparable<T>>
    Node<T> mergeSorted(Node<T> h1, Node<T> h2) {

        if (h1 == null) return h2;
        if (h2 == null) return h1;

        Node<T> dummy = new Node<>(null, null);
        Node<T> tail = dummy;

        while (h1 != null && h2 != null) {
            if (h1.getElement().compareTo(h2.getElement()) <= 0) {
                tail.setNext(h1);
                h1 = h1.getNext();
            } else {
                tail.setNext(h2);
                h2 = h2.getNext();
            }
            tail = tail.getNext();
        }

        // Attach remaining nodes
        tail.setNext((h1 != null) ? h1 : h2);

        return dummy.getNext();
    }
}
