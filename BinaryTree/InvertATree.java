package BinaryTree;

public class InvertATree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Original Tree:");
        printTree(root, 0);

        invertTree(root);

        System.out.println("Inverted Tree:");
        printTree(root, 0);
    }

    private static void printTree(Node node, int level) {
        if (node == null) {
            return;
        }
        printTree(node.right, level + 1);
        System.out.println(" ".repeat(level * 4) + node.value);
        printTree(node.left, level + 1);
    }

    private static void  invertTree(Node node) {
        if (node == null) {
            return;
        }

        invertTree(node.left);
        invertTree(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
