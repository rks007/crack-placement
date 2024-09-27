package binaryTrees;

import java.util.ArrayList;

public class morrisTraversalPreorder {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    private static ArrayList<Integer> morrisTraversal(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        Node curr = root;

        while(curr != null){

            if(curr.left == null){
                result.add(curr.val);
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    result.add(curr.val);
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
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

        ArrayList<Integer> result = morrisTraversal(a);
        System.out.println(result);
    }
}
