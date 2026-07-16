class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> mp = new HashMap<>();
        if(s1.length() >s2.length()) return false;
        for(int i=0;i<s1.length();i++){
            char c = s1.charAt(i);
            mp.put(c, mp.getOrDefault(c,0)+1);
        }
        int i = 0;
        int j = 0;
        int count = s1.length();
        while(j<s2.length()){
            char c = s2.charAt(j);
            int windowSize = j-i+1;
            if(mp.containsKey(c)){
                if(mp.get(c) > 0){
                    count--;
                }
                mp.put(c, mp.get(c)-1);
            }
            if(windowSize > s1.length()) {
                char ch = s2.charAt(i);
                if(mp.containsKey(ch)){
                    if(mp.get(ch)>=0){
                        count++;
                    }
                    mp.put(ch, mp.get(ch)+1);
                }
                i++;
            }
            if(count == 0) return true;
            j++;
        }
        return false;
    }
}
