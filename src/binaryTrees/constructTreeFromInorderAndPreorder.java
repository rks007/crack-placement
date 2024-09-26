package binaryTrees;

import java.util.HashMap;

public class constructTreeFromInorderAndPreorder {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            inMap.put(inorder[i], i);
        }

        Node root = buildTreee(preorder, 0, n - 1, inorder, 0, n - 1, inMap);

        return root;
    }
    private static Node buildTreee(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap){

        if(preStart > preEnd || inStart > inEnd){//if any time any array become empty then return null
            return null;
        }
        Node root = new Node(preorder[preStart]); //creating the root element

        int inRoot = inMap.get(root.data); //index of root element in inorder array
        int leftSize = inRoot - inStart;  //size of left part from the root element of inorder array

        root.left = buildTreee(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTreee(preorder, preStart + leftSize + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;

    }

}
