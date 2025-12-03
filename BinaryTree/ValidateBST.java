package BinaryTree;

public class ValidateBST {
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(3);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        System.out.println("The given tree is a valid Binary Search tree : " + isValidBST(root));

    }

    private static boolean isValidBST(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        return (root.left.value <= root.value) && (root.value <= root.right.value) &&
        isValidBST(root.left) && isValidBST(root.right);
    }
}
