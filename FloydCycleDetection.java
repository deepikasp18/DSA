package LinkedList;

public class FloydCycleDetection {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creating a cycle here

        boolean hasCycle = detectCycle(head);
        System.out.println("Linked List has cycle: " + hasCycle);
    }

    private static boolean detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow =head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer by 1
            fast = fast.next.next;     // Move fast pointer by 2

            if (slow == fast) {        // Cycle detected
                return true;
            }
        }
        return false;
    }
}
