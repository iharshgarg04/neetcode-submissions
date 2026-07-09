class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int val: nums){
            set.add(val);
        }
        int max =0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int val = nums[i];
                int count=0;
                while(set.contains(val++)){
                    count++;
                }
                max = Math.max(count,max);
            }
        }
        return max;
    }
}
