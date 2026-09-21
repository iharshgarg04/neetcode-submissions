class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int startAtZero = solve(cost, 0, n, 0, dp);
        int startAtone = solve(cost, 1, n, 0, dp);
        return Math.min(startAtZero, startAtone);
    }

    private int solve(int []cost, int index, int len, int ans, int dp[]){
        if(index >= len) return 0;
        if(dp[index] != -1) return dp[index];
        int onestep = solve(cost, index+1, len, ans+cost[index], dp);
        int twostep = solve(cost, index+2, len, ans+cost[index], dp);
         
        return dp[index] = cost[index] + Math.min(onestep, twostep);
    }
}
