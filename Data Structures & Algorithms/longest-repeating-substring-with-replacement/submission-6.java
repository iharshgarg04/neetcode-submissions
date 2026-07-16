class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int ans =0;
        int i=0;
        int j=0;
        HashMap<Character,Integer> mp = new HashMap<>();
        int max = 0;
        while(j<n){
            char c = s.charAt(j);
            int windowSize = j-i+1;
            mp.put(c, mp.getOrDefault(c,0)+1);
            max = Math.max(max, mp.get(c));
            if(windowSize - max > k) {
                char leftChar = s.charAt(i);
                mp.put(leftChar ,mp.get(leftChar)-1);
                i++;
            }
            ans = Math.max(j-i+1, ans);
            j++;
        }
        return ans;
    }
}
