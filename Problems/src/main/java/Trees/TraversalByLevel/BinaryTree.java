package Trees.TraversalByLevel;

import java.util.PriorityQueue;

/*
The task is to print level order traversal in a way that nodes of all levels are printed
*/
public class BinaryTree {

    private Node root;

    public BinaryTree() {
    }

    public BinaryTree(int data) {
        this.root = new Node(data);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node getRoot() {
        return root;
    }

    class Node {
         final int data;
         final Node left;
         final Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void printTreeByLevels(BinaryTree tree) {
        PriorityQueue<Node> Q = new PriorityQueue<>();

        if (!tree.isEmpty()) {
            Q.add(tree.getRoot());

            while (!Q.isEmpty()) {
                Node node = Q.remove();
                System.out.println(node.data);

                if (null != node.left) {
                    Q.add(node.left);
                }

                if (null != node.right) {
                    Q.add(node.right);
                }
            }
        }
    }

}


