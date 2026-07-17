class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        int idx =0;

        for(int j=0;j<nums.length;j++){

            while(!dq.isEmpty() && dq.peekFirst() <= j-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[j] >= nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offerLast(j);
            if(j >= k-1){
                ans[idx++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}
