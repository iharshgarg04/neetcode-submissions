class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> mp = new HashMap<>();
        for(String s: strs){
            char []chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if(!mp.containsKey(sorted)){
                mp.put(sorted, new ArrayList<>());
            }

            mp.get(sorted).add(s);
        }

        for(List<String> group: mp.values()){
            ans.add(group);
        }

        return ans;
    }
}
