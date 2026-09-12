class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n, dp);
    }

    private int solve(int n, int dp[]){
        if(n<=0) return 1;

        if(dp[n] != -1) return dp[n];

        int onestep = solve(n-1, dp);
        int twostep = 0;
        if(n>1){
            twostep = solve(n-2, dp);
        } 

        return dp[n] = onestep + twostep;
    }
}
