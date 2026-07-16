class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i=0;
        int j=0;
        ArrayList<Integer> ans = new ArrayList<>();
        int max = 0;
        while(j<nums.length){
            int windowSize = j-i+1;
            max = Math.max(max, nums[j]);
            if(windowSize == k){
                ans.add(max);
                i++;
            }
            j++;
        }
        int result[] = new int[ans.size()];
        i=0;
        for(int val: ans){
            result[i++] = val; 
        }
        return result;
    }
}
