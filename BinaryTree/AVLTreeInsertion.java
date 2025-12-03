package BinaryTree;

public class AVLTreeInsertion {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        int valueToInsert = 6;

        root = insertIntoAVL(root, valueToInsert);
        inorderTraversal(root);
    }

    private static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value + " ");
            inorderTraversal(root.right);
        }
    }

    private static Node insertIntoAVL(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.value) {
            node.left = insertIntoAVL(node.left, key);
        } else if (key > node.value) {
            node.right = insertIntoAVL(node.right, key);
        } else {
            return node; // Duplicate keys are not allowed
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        // Left Left Case (Key inserted in left subtree of left child)
        if (balance > 1 && key < node.left.value) {
            return rightRotate(node);
        }

        // Right Right Case (Key inserted in right subtree of right child)
        if (balance < -1 && key > node.right.value) {
            return leftRotate(node);
        }

        /*
        *          50
        *         /
        *       20
        *         \
        *           30
        * 
        *       left rotation 
        * 
        *          50
        *        /
        *      20 (unbalanced node)
        *       \
        *        30 (newRoot)
        * 
        *       After Left Rotation
        *       50
        *      /
        *     30
        *   /
        * 20
        * 
        *       Right rotation
        * 
        *           50 (unbalanced node)
        *         /
        *       30 (newRoot)
        *     /
        *  20
        * 
        *      After Right Rotation
        *      30   
        *     /  \
        *    20   50
        *   
        */
        // Left Right Case (Key inserted in right subtree of left child)
        if (balance < 1 && key > node.right.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        /*
                50 
        *           \
        *            60
        *           /
        *           55
        * 
        *    right rotation
        * 
        *          50
        *             \ 
        *           60 (unbalanced node)
        *       /
        *    55 (newRoot)
        * 
        *     After Right Rotation
        * 
        *        50
        *          \
        *           55
        *             \
        *               60
        * 
        *      left rotation
        * 
        *          50 (unbalanced node)
        *            \
        *           55 (newRoot)
        *             \
        *               60
        * 
        *       After Left Rotation
        *        55
        *       /  \
        *     50   60
        *        
        * 
        */
        // Right Left Case (Key inserted in left subtree of right child)
        if (balance > 1 && key < node.left.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /**
     *              50 (unbalanced node)
     *            /
     *          20 (newRoot)
     *         /
     *      10
     *  
           After Right Rotation
     * 
     *           20
     *          /  \
     *        10   50
     */
    private static Node rightRotate(Node node) {
        Node newRoot = node.left;
        Node temp = newRoot.right;

        newRoot.right = node;
        node.left = temp;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    /*
        *          20 (unbalanced node)
        *            \
        *             50 (newRoot)
        *               \
        *               70
        *  
            After Left Rotation
        * 
        *           50
        *          /  \
        *        20   70
    */

    private static Node leftRotate(Node node) {
        Node newRoot = node.right;
        Node temp = newRoot.left;

        newRoot.left = node;
        node.right = temp;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    private static int getBalance(Node node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private static int getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    public static class Node {
        int value;
        Node left, right;
        int height;

        Node(int d) {
            value = d;
            height = 1;
        }
    }
}
