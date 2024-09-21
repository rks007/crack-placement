package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class zigZagTraversal {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node (3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        int heightOfTree = height(a);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i <= heightOfTree; i++){

            List<Integer> arr = new ArrayList<>();

            if(i % 2 == 0){ //if height is even then print in reverse
                levelOrder2(a, i, arr);
            } else {
                levelOrder1(a, i , arr);
            }

            ans.add(arr);
        }
        System.out.println(ans);
    }
    private static void levelOrder1(Node root, int n, List<Integer> arr){ //for left to right printing
        if(root == null){
            return;
        }
        if(n == 1){
            arr.add(root.val);
        }
        levelOrder1(root.left, n - 1, arr);
        levelOrder1(root.right, n - 1, arr);
    }
    private static void levelOrder2(Node root, int n, List<Integer> arr){ //for reverse
        if(root == null){
            return;
        }
        if(n == 1){
            arr.add(root.val);
        }
        levelOrder2(root.right, n - 1, arr);
        levelOrder2(root.left, n - 1, arr);
    }
    private static int height(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
