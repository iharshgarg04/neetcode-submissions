class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            if(i>0 && nums[i] == nums[i-1]) continue;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    ans.add(new ArrayList<>(res));
                    j++;
                    k--;
                } else if(sum>0){
                    while(k< nums.length-1 && nums[k] == nums[k+1]) k--;
                    k--;
                } else{
                    while(nums[j] == nums[j-1]) j++;
                    j++;
                }
            }
        }
        return ans;
    }
}
