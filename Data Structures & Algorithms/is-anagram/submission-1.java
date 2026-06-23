class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i),0) + 1);
        }

        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);

            if(!mp.containsKey(c)) return false;

            mp.put(c, mp.get(c)-1);
            if(mp.get(c) == 0){
                mp.remove(c);
            }
        }

        return mp.size() == 0;
    }
}
