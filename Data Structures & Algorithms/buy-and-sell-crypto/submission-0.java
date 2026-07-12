class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int ans = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] < buy){
                buy = prices[i];
            }
            ans = Math.max(prices[i] - buy, ans);
        }
        return ans;
    }
}
