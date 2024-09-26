package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class rootToNodePath {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    private static boolean path(Node root, List<Integer> ans, int target){
        if(root == null){
            return false;
        }

        ans.add(root.val);
        if(root.val == target){
            return true;
        }

        if(path(root.left, ans, target) || path(root.right, ans, target)){
            return true;
        }

        ans.remove(ans.size() - 1);
        return false;

    }

    private static List<Integer> ans(Node root, int target){
        List<Integer> arr = new ArrayList<>();

        if(root == null){
            return arr;
        }

        path(root, arr, target);

        return arr;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);


        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        e.right = f;

        System.out.println("root to node path is");

        List<Integer> ans = new ArrayList<>();
        ans = ans(a, 6);
        System.out.println(ans);


    }
}
