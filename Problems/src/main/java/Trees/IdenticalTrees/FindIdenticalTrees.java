package Trees.IdenticalTrees;

/*
Write a function to determine if two trees are identical or not:
Two trees are identical when they have the same data and the arrangement of data is also the same
*/

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class FindIdenticalTrees {
    public static boolean isIdentical(Node root1, Node root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 != null && root2 != null){
            return (root1.data == root2.data &&
                    isIdentical(root1.left, root2.left) &&
                    isIdentical(root1.right, root2.right));
        }
        return false;
    }
}
