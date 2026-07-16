class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int ans =0;
        for(int i=0;i<n;i++){
            HashMap<Character,Integer> mp = new HashMap<>();
            for(int j=i;j<n;j++){
                char c = s.charAt(j);
                int windowSize = j-i+1;
                int max = 0;
                mp.put(c, mp.getOrDefault(c,0)+1);
                max = Math.max(max, mp.get(c));
                if(windowSize - max <= k) {
                    ans = Math.max(windowSize, ans);
                }
            }
        }
        return ans;
    }
}
