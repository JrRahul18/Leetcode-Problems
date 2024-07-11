class Solution {
    public String reverseParentheses(String s) {
        String finalAns = "";
        Stack<Integer> stk = new Stack<>();
        int[] closing = new int[s.length()];
        for(int i=0;i<s.length(); i++){
            if(s.charAt(i) == '('){
                stk.push(i);
            }else if(s.charAt(i)==')'){
                int j = stk.peek();
                stk.pop();
                closing[i] = j;
                closing[j] = i;
            }
            
        }
        
        int flag = 1;
        for(int i=0; i<s.length(); i+=flag){
            if(s.charAt(i) =='(' || s.charAt(i)==')'){
                i=closing[i];
                flag = -flag;
            }
            else{
                finalAns+=s.charAt(i);
            }
        }
        return finalAns;
    }
}