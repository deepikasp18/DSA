package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        int k = 3;
        int kthSmallest = findKthSmallest(root, k);
        System.out.println("The " + k + "th smallest element in the BST is: " + kthSmallest);
    }

    private static int findKthSmallest(Node root, int k) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result.get(k-1);
    }

    private static void inOrderTraversal(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, result);

        result.add(root.value);

        inOrderTraversal(root.right, result);
    }
}
