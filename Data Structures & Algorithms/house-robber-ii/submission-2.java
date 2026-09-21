class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int dp[] = new int[n+1];
        int dp2[] = new int[n+1];
        Arrays.fill(dp, -1);
        Arrays.fill(dp2, -1);
        int first = solve(nums, dp, n-1, 1);
        int second = solve(nums, dp2, n-2, 0);
        return Math.max(first, second);
    }


    private int solve(int []nums, int dp[], int index, int start){

        if(index < start) return 0;

        if(dp[index] != -1) return dp[index];

        int skip = solve(nums, dp, index-1, start);
        int rob = nums[index] + solve(nums, dp, index-2, start);

        return dp[index] = Math.max(skip, rob);
    }
}
