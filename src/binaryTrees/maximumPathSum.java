package binaryTrees;

public class maximumPathSum {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    static int maxPathSumAns = 0;
    private static int maxPath(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = Math.max(0, maxPath(root.left));
        int rightSum = Math.max(0, maxPath(root.right));

        maxPathSumAns = Math.max(maxPathSumAns, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }

    private static int maxPathOptimal(Node root, int[] max){
        /* why this approach is optimal
           because it do not consider negative values
           for confirmation dry run tree whiich preorder traversal is 15, 10, 20, -30, -15
        */
        if(root == null){
            return 0;
        }
        int leftSum = Math.max(0, maxPathOptimal(root.left, max));//do not consider negative values
        int rightSum = Math.max(0, maxPathOptimal(root.right, max));//do not consider negative values

        max[0] = Math.max(max[0], root.val + leftSum + rightSum);

        //if you do not understand the return line then dry run this on any example
        return root.val + Math.max(leftSum, rightSum);
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

        System.out.println(a.val);

        maxPath(a);
        System.out.println("maximum path sum- " + maxPathSumAns);

        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathOptimal(a, max);
        System.out.println("maximum path sum optimal approach- " + max[0]);
    }
}
