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
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return solve(root,k);
    }

    public int solve(TreeNode root, int k){
        if(root == null) return -1;

        int left = solve(root.left,k);

        if(left != -1) return left;

        count--;
        
        if(count == 0){
            return root.val;
        }

        return solve(root.right, k);
    }
}
