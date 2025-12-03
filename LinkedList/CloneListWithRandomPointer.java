package LinkedList;
public class CloneListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            Node newNode = new Node(head.val);
            newNode.random = head.random;
            return newNode;
        }

        Node current = head;

        // Create new nodes and insert them next to original nodes
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // Assign random pointers for the new nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Separate the two lists
        current = head;
        Node clonedHead = head.next;
        Node clone = head.next;

        while (clone.next != null) {
            current.next = current.next.next;
            clone.next = clone.next.next;

            current = current.next;
            clone = clone.next;
        }

        current.next = null; // Terminate the original list
        clone.next = null;  // Terminate the cloned list

        return clonedHead;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node clonedList = copyRandomList(node1);
        printList(clonedList);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            int randomVal = (current.random != null) ? current.random.val : -1;
            System.out.println("Node val: " + current.val + ", Random points to: " + randomVal);
            current = current.next;
        }
    }   
}