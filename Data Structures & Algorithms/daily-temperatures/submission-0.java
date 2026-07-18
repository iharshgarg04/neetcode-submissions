class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[temperatures.length];
        st.push(0);
        for(int i=1;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int topIndex = st.peek();
                ans[topIndex] = i-topIndex;
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}
