class Solution {
    public int characterReplacement(String s, int k) {
        HashSet<Character> st = new HashSet<>();
        int i=0;
        int j=0;
        int ans = 0;
        int temp =k;
        while(j<s.length()){
            char c = s.charAt(i);
            st.add(c);
            while(temp>0 && j<s.length()-1){
                if(st.contains(c)){
                    j++;
                } else {
                    temp--;
                    j++;
                }
                c = s.charAt(j);
            }
            ans = Math.max(ans, j-i+1);
            st.remove(c);
            i++;
            j=i;
            temp =k;
        }
        return ans;
    }
}
