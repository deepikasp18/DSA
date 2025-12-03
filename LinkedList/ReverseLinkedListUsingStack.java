package LinkedList;

public class ReverseLinkedListUsingStack {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        ListNode reversedHead = reverseListUsingStack(head);

        System.out.println("Reversed Linked List using Stack:");
        printList(reversedHead);
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    private static ListNode reverseListUsingStack(ListNode head) {
        java.util.Stack<ListNode> stack = new java.util.Stack<>();
        ListNode current = head;

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        // Push all nodes onto the stack
        while (current != null) {
            stack.push(current);
            current = current.next;
        }


        // Pop the first node to be the new head
        ListNode newHead = stack.pop();
        current = newHead;

        // Pop remaining nodes and adjust pointers
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null; // Set the next of the last node to null

        return newHead;
    }
}
