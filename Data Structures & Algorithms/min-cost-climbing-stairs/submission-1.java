class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int startAtZero = solve(cost, 0, n, 0);
        int startAtone = solve(cost, 1, n, 0);
        return Math.min(startAtZero, startAtone);
    }

    private int solve(int []cost, int index, int len, int ans){
        if(index >= len) return 0;

        int onestep = solve(cost, index+1, len, ans+cost[index]);
        int twostep = solve(cost, index+2, len, ans+cost[index]);
         
        return cost[index] + Math.min(onestep, twostep);
    }
}
