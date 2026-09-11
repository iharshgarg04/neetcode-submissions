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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i], i);
        }
        return construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, mp);
    }

    private TreeNode construct(int []preorder, int preStart, int preEnd, int []inorder, int inStart, int inEnd, HashMap<Integer, Integer> mp){
        

        if(preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
            
        int inRoot = mp.get(preorder[preStart]);
        int numLeft = inRoot - inStart;

        root.left = construct(preorder, preStart+1, preEnd, inorder, inStart, inRoot-1, mp);
        root.right = construct(preorder, preStart + numLeft + 1, preEnd, inorder, inRoot+1, inEnd, mp);

        return root;
    }
}
