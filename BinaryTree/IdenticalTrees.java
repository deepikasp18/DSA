package BinaryTree;

public class IdenticalTrees {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.left.right.right = new Node(6);

        boolean result = areIdentical(root1, root2);
        System.out.println("The two trees are identical: " + result);
    }

    private static boolean areIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return (node1.value == node2.value) && areIdentical(node1.left, node2.left) && areIdentical(node1.right, node2.right);
    }
}
