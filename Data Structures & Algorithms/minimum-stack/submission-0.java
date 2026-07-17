class MinStack {
    Stack<Integer> st;
    public MinStack() {
       st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        Stack<Integer> temp = new Stack<>();
        int min = Integer.MAX_VALUE;
        while(!st.isEmpty()){
            int top = st.pop();
            min = Math.min(min, top);
            temp.push(top);
        }

        while(!temp.isEmpty()){
            int top = temp.pop();
            st.push(top);
        }

        return min;
    }
}
