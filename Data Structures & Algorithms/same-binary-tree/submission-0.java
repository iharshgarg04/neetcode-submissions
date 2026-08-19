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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p, q);
    }

    private boolean solve(TreeNode p, TreeNode q){

        if(p.left == null && q.left != null) return false;
        if(p.left != null && q.left == null) return false;
        if(p.val != q.val) return false;
        if(p.left == null && q.left == null) return true;

        return solve(p.left, q.left) && solve(p.right, q.right);
    }
}
