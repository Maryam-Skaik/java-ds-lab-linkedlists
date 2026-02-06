package assignment_solutions;

/**
 * Problem:
 * Check whether a Singly Linked List is a palindrome.
 *
 * Approach:
 * - Create a reversed copy of the list
 * - Compare original list with reversed list (only up to size/2)
 *
 * Why this works:
 * - Palindrome means symmetric order
 * - Reversing allows direct comparison
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class PalindromeSLL<T> {

    private Node<T> head;
    private int size;

    public boolean isPalindrome() {

        // Create a reversed copy of the list
        SLL<T> reversed = new SLL<>();

        Node<T> current = head;
        while (current != null) {
            reversed.insertAtHead(current.getElement());
            current = current.getNext();
        }

        // Compare original and reversed list
        Node<T> p1 = head;
        Node<T> p2 = reversed.getHead();

        for (int i = 0; i < size / 2; i++) {
            if (!p1.getElement().equals(p2.getElement())) {
                return false;
            }
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return true;
    }
}
