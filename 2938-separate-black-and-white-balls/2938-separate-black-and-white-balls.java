class Solution {
    public long minimumSteps(String s) {
        long finalAns = 0;
        int black = 0;
        
        for(char ch: s.toCharArray()){
            if(ch == '0'){
                finalAns += (long) black;
            }
            else if(ch == '1'){
                black++;
            }
        }
        return finalAns;
    }
}