class Solution {
    public int minimumDeletions(String s) {
        int finalAns=0;
        Stack<Character> stk = new Stack<>();
        for(char ch: s.toCharArray()){
            if(!stk.isEmpty() && ch=='a' && stk.peek()=='b'){
                finalAns++;
                stk.pop();
            }
            else{
                stk.push(ch);
            }
        }
        return finalAns;
    }
}