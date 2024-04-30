package Trees.BalanceTree;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class FindIfTreeBalanced {
    public static boolean isBalanced(Node root) {
        if (null == root) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    private static int height(Node root) {
        if (null == root) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
