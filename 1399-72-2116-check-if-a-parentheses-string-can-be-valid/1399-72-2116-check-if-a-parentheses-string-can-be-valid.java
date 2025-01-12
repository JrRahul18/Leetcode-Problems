class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2 != 0) return false;
        int leftOpen=0, rightClose=0;

        for(int i=0; i<s.length(); i++){
            if(locked.charAt(i) == '0' || s.charAt(i) == '('){
                leftOpen++;
            }
            else{
                leftOpen--;
            }
            if(leftOpen < 0) return false;
        }

        for(int i=s.length()-1; i>=0; i--){
            if(locked.charAt(i) == '0' || s.charAt(i) == ')'){
                rightClose++;
            }
            else{
                rightClose--;
            }
            if(rightClose < 0) return false;
        }
        return true;
    }
}