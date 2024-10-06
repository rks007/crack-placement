package binaryTrees;

public class FlattenBInaryTreeToLinkedListOptimal { //leetcode 114
    public static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
    }
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
