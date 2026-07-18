class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int high = Integer.MIN_VALUE;
        int low = 1;
        for(int val: piles){
            high = Math.max(val, high);
        }
        int min = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canEatAllBananas(mid, piles, h)){
                min = Math.min(min, mid);
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return min;
    }
    private boolean canEatAllBananas(int mid, int[] piles, int h){
        for(int i=0;i<piles.length;i++){
            h -= (int) Math.ceil((double)piles[i]/mid);
        }
        return h>=0;
    }
}
