package LinkedList;

public class DeleteNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2; // Delete the 2nd node from the end

        System.out.println("Original Linked List:");
        printList(head);

        ListNode modifiedHead = deleteNthFromEndUsingLength(head, n);
        System.out.println("Linked List after deleting " + n + "th node from the end using Length:");
        printList(modifiedHead);

        // Two pointer approach
        modifiedHead = deleteNthFromEndUsingTwoPointers(head, n);
        System.out.println("Linked List after deleting " + n + "th node from the end using Two Pointers:");
        printList(modifiedHead);
    }

    private static ListNode deleteNthFromEndUsingLength(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        if (n == 1 && head.next == null) {
            return null; // If there's only one node and we need to delete it
        }

        // First, calculate the length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // If n is equal to the length, we need to remove the head
        if (n == length) {
            return head.next; // Remove the head
        }

        // Find the (length - n)th node
        current = head;
        for (int i=1; i<length - n; i++) {
            current = current.next;
        }

        current.next = current.next.next; // Bypass the nth node from the end
        return head;

    }

    /*
     * Fast starts from n 
     * Slow starts from 0
     * when fast reaches end, slow will be at (length - n)
     * 
     * 
     * If length = 5, n = 2
     * fast moves 2 steps ahead 
     * fast starts from index 3th node from start (index 2)
     * slow starts from index 1st node from start (index 0)
     * 
     * when fast reaches end (5th node, index 4 ), slow will be at 3rd node (index 2) which is 3rd node from end
     * then we can delete slow.next (4th node, index 3) 2nd node from end
     * 
     */

    private static ListNode deleteNthFromEndUsingTwoPointers(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        if (n == 1 && head.next == null) {
            return null; // If there's only one node and we need to delete it
        }

        ListNode fast = head;
        ListNode slow = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast is null, we need to remove the head
        if (fast == null) {
            return head.next; // Remove the head
        }

        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next; // Bypass the nth node from the end
        return head;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
