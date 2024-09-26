package binaryTrees;

import java.util.HashMap;

public class constructTreeFromPostOrderAndInOrder {

    Node buildTree(int n, int in[], int post[]) {
        // Your code here
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            inMap.put(in[i], i);
        }

        Node root = constructTree(post, 0, n - 1, in, 0, n - 1, inMap);

        return root;
    }
    private static Node constructTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        Node root = new Node(postorder[postEnd]);

        int inRoot = inMap.get(postorder[postEnd]);
        int leftSize = inRoot - inStart;

        root.left = constructTree(postorder, postStart, postStart + leftSize - 1, inorder, inStart, inRoot - 1, inMap);
        root.right = constructTree(postorder, postStart + leftSize, postEnd - 1, inorder, inRoot + 1, inEnd, inMap);

        return root;

    }

}
