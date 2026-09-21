class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int startFromEnd = solve(nums,n-1, dp);
        int startFromSecondLast = solve(nums,n-2, dp);
        return Math.max(startFromEnd, startFromSecondLast);
    }

    private int solve(int nums[], int index, int dp[]){
        if(index < 0) return 0;
        if(index == 0) return nums[index];

        if(dp[index] != -1) return dp[index];

        int rob = nums[index] + solve(nums, index-2, dp);
        int skip = solve(nums, index-1, dp);

        return dp[index] = Math.max(rob, skip);
    }
}
