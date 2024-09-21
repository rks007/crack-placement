package binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTraversal {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    private static void levelOrderTraversal(Node root, Queue<Node> q){
        if(root == null){
            return;
        }
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            System.out.print(node.val + " ");
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }

    }

    private static void levelOrderTraversal2(Node root, int n){ //n is the height
        if(root == null){
            return;
        }
        if(n == 1){
            System.out.print(root.val + " ");
        }
        levelOrderTraversal2(root.left, n - 1);
        levelOrderTraversal2(root.right, n - 1);
    }

    private static int height(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
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

        Queue<Node> q = new LinkedList<>();

        levelOrderTraversal(a, q);


        System.out.println();
        System.out.println("height is " + height(a));


        System.out.println();
        //printing level order traversal without queue
        //the optimal way
        int heightofTree = height(a);
        for(int i = 1; i <= heightofTree; i++ ){
            levelOrderTraversal2(a,i);
        }
    }
}
