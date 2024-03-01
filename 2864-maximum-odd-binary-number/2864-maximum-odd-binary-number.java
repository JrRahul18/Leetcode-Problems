class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        String finalAns = "";
        for(int i=0; i<s.length()-1; i++){
            if(count>1){
                finalAns+='1';
                count--;
            }
            else{
                finalAns+='0';
            }
        }
        finalAns+='1';
        return finalAns;
    }
}