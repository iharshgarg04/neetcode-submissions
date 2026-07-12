class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> st = new HashSet<>();
        int i=0;
        int j=0;
        int ans=0;
        while(j<s.length()){
            if(i==j){
                st.add(s.charAt(j));
                j++;
            }; 
            while(i!=j && j<s.length() && !st.contains(s.charAt(j))){
                st.add(s.charAt(j));
                j++;
            }
            ans = Math.max(ans, j-i);
            while(i!=j)i++;
        }
        return ans;
    }
}
