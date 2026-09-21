class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        int first = solve(nums, dp, n-1);
        int second = solve(nums, dp, n-2);
        return Math.max(first, second);
    }


    private int solve(int []nums, int dp[], int index){

        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];

        int skip = solve(nums, dp, index-1);
        int rob = 0;
        if(index != 0){
            rob = nums[index] + solve(nums, dp, index-2);
        }

        return dp[index] = Math.max(skip, rob);
    }
}
