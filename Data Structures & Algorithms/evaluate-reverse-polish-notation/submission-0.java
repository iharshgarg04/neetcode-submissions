class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (str.equals("+")) {
                int val1 = st.pop();
                int val2 = st.pop();
                st.push(val1 + val2);
            } else if (str.equals("*")) {
                int val1 = st.pop();
                int val2 = st.pop();
                st.push(val1 * val2);
            } else if (str.equals("-")) {
                int val1 = st.pop();
                int val2 = st.pop();
                st.push(val1 - val2);
            } else if (str.equals("/")) {
                int val1 = st.pop();
                int val2 = st.pop();
                st.push(val1 / val2);
            } else {
                st.push(Integer.parseInt(str));
            }
        }
        return finalVal;
    }
}
