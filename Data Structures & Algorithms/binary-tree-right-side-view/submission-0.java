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
    class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        HashMap<Integer, Integer> mp = new HashMap<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int level = p.level;

                mp.put(level, node.val);

                if(node.left != null) q.add(new Pair(node.left, level+1));
                if(node.right != null) q.add(new Pair(node.right, level+1));  
            }
        }

        for(int it: mp.values()){
            ans.add(it);
        }

        return ans;
    }
}
