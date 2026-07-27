class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int s = 0;
        int e = n1;
        int total = n1+n2;
        while(s<=e){
            int firstPartition = (s+e)/2;
            int secondPartition = (n1+n2+1)/2 - firstPartition;

            int l1 = firstPartition == 0 ? Integer.MIN_VALUE : nums1[firstPartition-1];
            int r1 = firstPartition == n1 ? Integer.MAX_VALUE : nums1[firstPartition];

            int l2 = secondPartition == 0 ? Integer.MIN_VALUE : nums2[secondPartition-1];
            int r2 = secondPartition == n2 ? Integer.MAX_VALUE : nums2[secondPartition];

            if(l1 <= r2 && l2 <= r1){
                double ans = 0.0;
                if(total % 2 == 0){
                    ans = (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                } else {
                    ans = Math.max(l1,l2);
                }
                return ans;
            } else if(l1 > r2){
                e = firstPartition-1;
            } else {
                s = firstPartition+1;
            }
        }
        return 0.0;
    }
}
