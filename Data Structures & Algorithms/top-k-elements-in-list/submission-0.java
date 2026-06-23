class Pair{
    int val;
    int freq;
    Pair(int val, int freq){
        this.val = val;
        this.freq = freq;
    }
}


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int val: nums){
            mp.put(val, mp.getOrDefault(val,0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for(Map.Entry<Integer, Integer> val: mp.entrySet()){
            pq.add(new Pair(val.getKey(), val.getValue()));
        }
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            Pair topval = pq.poll();
            ans[i] = topval.val;
        }

        return ans;
    }
}
