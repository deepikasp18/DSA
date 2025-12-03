package BinaryTree;

public class MaximumDepth {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int depth = maxDepth(root);
        System.out.println("Maximum depth of the binary tree: " + depth);
    }

    public static int maxDepth(Node node) {
        if (node == null) {
            return -1;
        } else {
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
