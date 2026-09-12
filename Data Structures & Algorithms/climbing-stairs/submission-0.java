class Solution {
    public int climbStairs(int n) {
        return solve(n);
    }

    private int solve(int n){
        if(n<=0) return 1;

        int onestep = solve(n-1);
        int twostep = 0;
        if(n>1){
            twostep = solve(n-2);
        } 

        return onestep + twostep;
    }
}
