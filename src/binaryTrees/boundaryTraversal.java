package binaryTrees;

public class boundaryTraversal {
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
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);
        Node j = new Node(10);
        Node k = new Node(11);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        e.right = i;
        f.left = j;
        g.right = k;

        leftBoundary(a);
        bottomBoundary(a);
        rightBoundary(a.right);

    }
    private static void leftBoundary(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){ //because we dont want to print the leaf node in leftboundary, we will print them in bottom boundary separately
            return;
        }
        System.out.print(root.val + " ");
        if(root.left != null){
            leftBoundary(root.left);
        } else {
            leftBoundary(root.right);
        }
    }

    private static void bottomBoundary(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){ //only print the leaf node
            System.out.print(root.val + " ");
        }
        bottomBoundary(root.left);
        bottomBoundary(root.right);
    }

    private static void rightBoundary(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        if(root.right != null){
            rightBoundary(root.right);
        } else {
            rightBoundary(root.left);
        }
        System.out.print(root.val + " "); //for reverse printing we have put this statement in the last, i hope you know the reverse printing in the recursion
    }
}
