class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = 0;
        suffix[n-1] = 0;

        for(int i=1;i<n;i++){
            prefix[i] = Math.max(0, Math.max(prefix[i-1], height[i-1]));
            suffix[n-i-1] = Math.max(0, Math.max(suffix[n-i], height[n-i]));
        }
        int ans =0;
        for(int i=0;i<n;i++){
            ans += Math.max(0, Math.min(suffix[i], prefix[i]) - height[i]);
        }
        return ans;
    }
}
