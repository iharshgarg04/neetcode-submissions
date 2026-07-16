class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> mp = new HashMap<>();
        for(char c: t.toCharArray()){
            mp.put(c, mp.getOrDefault(c,0)+1);
        }

        int i=0;
        int j=0;
        int leftIndex = 0;
        int rightIndex = s.length()-1;
        int minWindow = Integer.MAX_VALUE;
        int count = t.length();
        while(j<s.length()){
            char c = s.charAt(j);
            if(mp.containsKey(c)){
                if(mp.get(c) > 0){
                    count--;
                }
                mp.put(c, mp.get(c)-1);
            }

            while(count==0){
                char ch = s.charAt(i);
                if(mp.containsKey(ch)){
                    count++;
                    mp.put(ch, mp.get(ch)+1);
                }
                if((j-i+1) < minWindow){
                    minWindow = j-i+1;
                    leftIndex = i;
                    rightIndex = j;
                }
                i++;
            }
            j++;
        }
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(leftIndex, rightIndex+1);
    }
}
