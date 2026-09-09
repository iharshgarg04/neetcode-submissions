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
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> res = new ArrayList<>();
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                int level = p.level;
                TreeNode node = p.node;
                if(node.left != null){
                    q.add(new Pair(node.left, level + 1));
                }
                if(node.right != null){
                    q.add(new Pair(node.right, level + 1));
                }
                res.add(p.node.val);
            }
            ans.add(new ArrayList<>(res));
        }

        return ans;
    }
}
