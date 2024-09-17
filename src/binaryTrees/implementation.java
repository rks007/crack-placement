package binaryTrees;

public class implementation {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    private static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    private static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    private static int maxValueNode(Node root){
        if(root == null){
            return 0;
        }
        int leftNode = maxValueNode(root.left);
        int rightNode = maxValueNode(root.right);
//        return Math.max(root.val, Math.max(maxValueNode(root.left), maxValueNode(root.right)));
        return Math.max(root.val, Math.max(leftNode, rightNode));
    }

    private static int size(Node root){
        if(root == null){
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    private static int height(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static boolean isbalanced(Node root){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left == null || root.right == null){
            return false;
        }
        int leftSubtreeHeight = height(root.left);
        int rightSubtreeHeight = height(root.right);

        return Math.abs(leftSubtreeHeight - rightSubtreeHeight) <= 1;

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

        preorder(a);
        System.out.println();
        inorder(a);
        System.out.println();
        postorder(a);
        System.out.println();

        int max = maxValueNode(a);
        System.out.println("maximum value node is- " + max);

        int sizeOfBinaryTree = size(a);
        System.out.println("size of the binary tree is- " + sizeOfBinaryTree);

        int heightOfTree = height(a);
        System.out.println("height of the binary tree is- " + heightOfTree);

        if(isbalanced(a)){
            System.out.println("the tree is balanced");
        } else {
            System.out.println("the tree is not balanced");
        }



    }
}
