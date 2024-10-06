package binaryTrees;

public class FlattenBinaryTreeToLinkedList {

    public static class Node{
        int val;
        Node left = null;
        Node right = null;
    }

    static Node prev = null;

    public static void flatten(Node root)
    {
        //code here

        if(root == null){
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }
}
