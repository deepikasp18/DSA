package BinaryTree;

public class BSTInsertion {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        int valueToInsert = 6;
        root = insertIntoBST(root, valueToInsert);
        inorderTraversal(root);
    }

    private static Node insertIntoBST(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.value) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    private static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value + " ");
            inorderTraversal(root.right);
        }
    }
}