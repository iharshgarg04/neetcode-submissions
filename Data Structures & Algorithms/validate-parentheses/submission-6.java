class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(!st.isEmpty() && 
                ((c == ']' && st.peek() == '[') ||
                (c == ')' && st.peek() =='(') ||
                (c == '}' && st.peek() == '{'))
            ){
                st.pop();
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
