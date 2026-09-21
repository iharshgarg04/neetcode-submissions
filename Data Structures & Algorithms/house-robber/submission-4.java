class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int startFromEnd = solve(nums,n-1, 0, dp);
        int startFromSecondLast = solve(nums,n-2, 0, dp);
        return Math.max(startFromEnd, startFromSecondLast);
    }

    private int solve(int nums[], int index, int ans, int dp[]){
        if(index < 0) return ans;
        if(index == 0) return ans + nums[index];

        if(dp[index] != -1) return dp[index];

        int max = 0;
        for(int i=index-2; i>=0; i--){
            max = Math.max(max, solve(nums, i, ans + nums[index], dp));
        }

        ans = Math.max(max, ans);

        return dp[index] = ans;
    }
}
