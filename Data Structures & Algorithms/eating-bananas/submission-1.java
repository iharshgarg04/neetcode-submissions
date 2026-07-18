class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        int low = piles[0];
        int high = piles[n-1];
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
