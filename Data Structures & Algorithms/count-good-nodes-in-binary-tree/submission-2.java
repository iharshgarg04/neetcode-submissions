class Solution {
    public int goodNodes(TreeNode root) {
        return solve(root, Integer.MIN_VALUE);
    }

    public int solve(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int cnt = root.val >= max ? 1 : 0;

        max = Math.max(max, root.val);

        int left = solve(root.left, max);
        int right = solve(root.right, max);

        return cnt + left + right;
    }
}