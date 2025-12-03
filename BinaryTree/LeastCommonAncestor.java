package BinaryTree;

public class LeastCommonAncestor {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        Node lca = findLCA(root, 5, 4);
        if (lca != null) {
            System.out.println("Least Common Ancestor of " + 5 + " and " + 4 + " is: " + lca.value);
        } else {
            System.out.println("One or both nodes are not present in the tree.");
        }

    }

    private static Node findLCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.value == n1 || root.value == n2) {
            return root;
        }

        Node leftLCA = findLCA(root.left, n1, n2);
        Node rightLCA = findLCA(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
