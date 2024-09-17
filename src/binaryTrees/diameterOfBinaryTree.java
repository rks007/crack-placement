package binaryTrees;

public class diameterOfBinaryTree {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    private static int height(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    private static int diameter(Node root, int max){
        if(root == null){
            return 0;
        }
        int lefth = height(root.left);
        int righth = height(root.right);

        return max = Math.max(max, (1 + lefth + righth));
    }

    private static int modifiedHeight(Node root, int[] diameter){
        if(root == null){
            return 0;
        }

        int lh = modifiedHeight(root.left, diameter);
        int rh = modifiedHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }
    private static int diameterOptimal(Node root){
        if(root == null) {
            return 0;
        }
        int[] diameter = new int[1];

        modifiedHeight(root, diameter);

        return diameter[0] + 1;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node (3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);


        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        e.right = f;



        System.out.println(height(a));
        System.out.println("diameter by brute force approach- " + diameter(a, Integer.MIN_VALUE));

        System.out.println("optimal approach for the diameter of binary tree- " + diameterOptimal(a));
    }
}
