package BinaryTree;

public class BSTDeletion {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        int valueToDelete = 5;
        root = deleteFromBST(root, valueToDelete);
        inorderTraversal(root);
    }

    private static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value + " ");
            inorderTraversal(root.right);
        }
    }

    private static Node deleteFromBST(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.value) {
            root.left = deleteFromBST(root.left, key);
        } else if (key > root.value) {
            root.right = deleteFromBST(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.value = getSuccessor(root.right);

            // Delete the inorder successor
            root.right = deleteFromBST(root.right, root.value);
        }

        return root;
    }

    private static int getSuccessor(Node node) {
        int minValue = node.value;
        while (node.left != null) {
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }
}
