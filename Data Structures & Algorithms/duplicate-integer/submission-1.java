class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int ele = 0;
        for(int i=0;i<nums.length;i++){
            if (count ==0){
                count++;
                ele = nums[i];
            } else if(nums[i] != ele){
                count = 1;
                ele = nums[i];
            } else if(nums[i] == ele) {
                return true;
            }
        }
        return false;
    }
}