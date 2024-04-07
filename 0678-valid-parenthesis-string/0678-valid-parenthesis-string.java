class Solution {
    public boolean checkValidString(String s) {
        int openCount=0, closeCount=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '*')openCount++;
            else openCount--;
            if(openCount <0) return false;
        }
        for(int i= s.length()-1; i>=0; i--){
            if(s.charAt(i) == ')' || s.charAt(i) == '*') closeCount++;
            else closeCount--;
            if(closeCount<0) return false;
        }
        return true;
        
    }
}