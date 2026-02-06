package linkedlists.assignment_solutions;

/**
 * Problem:
 * Remove duplicate elements from an unsorted Singly Linked List.
 *
 * Approach:
 * - Use two pointers:
 *   current → picks one element
 *   runner  → checks the rest of the list for duplicates
 *
 * No extra data structures allowed.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesSLL<T> {

    private Node<T> head;

    public void removeDuplicates() {

        Node<T> current = head;

        while (current != null) {

            Node<T> runner = current;

            while (runner.getNext() != null) {
                if (runner.getNext().getElement().equals(current.getElement())) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }

            current = current.getNext();
        }
    }
}
