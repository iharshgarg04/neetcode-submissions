/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        TreeNode rootLoc = findNode(root, subRoot);
        if(rootLoc == null) return false;
        return isSubTreePresent(rootLoc, subRoot);
    }

    private TreeNode findNode(TreeNode root, TreeNode subRoot){
        if(root == null) return null;
        if(root.val == subRoot.val) return root;

        TreeNode left = findNode(root.left, subRoot);
        if(left != null) return left;
        return findNode(root.right, subRoot);
    }

    private boolean isSubTreePresent(TreeNode root, TreeNode subRoot){
        if(root == null || subRoot == null){
            return root == subRoot;
        }

        if(root.val != subRoot.val) return false;

        return isSubTreePresent(root.left, subRoot.left) && isSubTreePresent(root.right, subRoot.right);
    }
}
