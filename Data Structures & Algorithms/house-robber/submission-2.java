class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int startFromEnd = solve(nums,n-1, 0);
        int startFromSecondLast = solve(nums,n-2, 0);
        return Math.max(startFromEnd, startFromSecondLast);
    }

    private int solve(int nums[], int index, int ans){
        if(index < 0) return ans;
        if(index == 0) return ans + nums[index];

        int max = 0;
        for(int i=index-2; i>=0; i--){
            max = Math.max(max, solve(nums, i, ans + nums[index]));
        }

        ans = Math.max(max, ans);

        return max;
    }
}
