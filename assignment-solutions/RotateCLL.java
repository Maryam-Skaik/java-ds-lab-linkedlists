package assignment_solutions;

/**
 * Bonus Problem:
 * Rotate a Circular Linked List (CLL) by k positions.
 *
 * Definition:
 * - Rotation means changing the head pointer
 * - The list remains circular
 *
 * Example:
 * 1 → 2 → 3 → 4 → (back to 1), k = 2
 * New head → 3
 *
 * Time Complexity: O(k)
 * Space Complexity: O(1)
 */
public class RotateCLL<T> {

    public Node<T> rotate(Node<T> head, int k) {

        if (head == null || k == 0) return head;

        Node<T> current = head;

        // Move k steps forward
        for (int i = 0; i < k; i++) {
            current = current.getNext();
        }

        // New head after rotation
        return current;
    }
}
