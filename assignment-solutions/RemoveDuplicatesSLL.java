package assignment_solutions;

/**
 * Problem:
 * Remove duplicate elements from a SORTED Singly Linked List.
 *
 * Example:
 * Input:  1 → 1 → 2 → 3 → 3 → 3 → 4
 * Output: 1 → 2 → 3 → 4
 *
 * Key Observation:
 * - In a sorted list, duplicate values always appear next to each other.
 *
 * Approach:
 * - Traverse the list once
 * - Compare the current node with the next node
 * - If both values are equal, skip the next node
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesSLL<T> {

    private Node<T> head;

    public void removeDuplicates() {

        Node<T> current = head;

        // Traverse until the second-last node
        while (current != null && current.getNext() != null) {

            // If current and next elements are equal, skip next
            if (current.getElement().equals(current.getNext().getElement())) {
                current.setNext(current.getNext().getNext());
            } else {
                // Move forward only when no duplicate is found
                current = current.getNext();
            }
        }
    }
}
