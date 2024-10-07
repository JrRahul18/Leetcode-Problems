class Solution {
    public int minLength(String s) {
        Stack<Character> stk = new Stack<>();
        for(char ch: s.toCharArray()){
            if(stk.isEmpty()){
                stk.push(ch);
                continue;
            }
            if((ch == 'B' && stk.peek() =='A') || (ch == 'D' && stk.peek() == 'C') ){
                stk.pop();
                continue;
            }
            else{
                stk.push(ch);
                continue;
            }
        }
        return stk.size();
    }
}