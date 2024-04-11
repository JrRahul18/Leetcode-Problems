class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder finalAns = new StringBuilder();
        // Stack<Integer> stk = new Stack<Integer>();
        for(int i=0; i<num.length(); i++){
            while(finalAns.length()>0 && finalAns.charAt(finalAns.length()-1) > num.charAt(i) && k>0){
                finalAns.deleteCharAt(finalAns.length()-1);
                k--;
            }
            if(finalAns.length()>0 || num.charAt(i) != '0'){
                finalAns.append(num.charAt(i));
            }
        }
        while(k>0 && finalAns.length()>0 ){
            finalAns.deleteCharAt(finalAns.length()-1);
            k--;
        }
        if(finalAns.length() == 0) return "0";
        return finalAns.toString();
        
    }
}