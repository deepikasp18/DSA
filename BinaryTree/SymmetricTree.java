package BinaryTree;

public class SymmetricTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        boolean result = isSymmetric(root);
        System.out.println("The tree is symmetric: " + result);
    }

    private static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.value == node2.value)
                && isMirror(node1.left, node2.right)
                && isMirror(node1.right, node2.left);
    }
}
