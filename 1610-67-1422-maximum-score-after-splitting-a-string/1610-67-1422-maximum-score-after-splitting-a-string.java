class Solution {
    public int maxScore(String s) {
        int zeroCount = 0;
        int onesCount = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '0') zeroCount++;
            else onesCount++;
        }

        int finalAns = 0;
        int zeroVal = 0;
        int oneVal = onesCount;

        for(int i = 0; i<s.length()-1; i++){
            if(s.charAt(i) == '0'){
                zeroVal++;
                int tempAns = zeroVal + oneVal;
                finalAns = Math.max(finalAns, tempAns);
            }
            else{
                oneVal--;
                int tempAns = zeroVal + oneVal;
                finalAns = Math.max(finalAns, tempAns);
            }
        }
        return finalAns;
    }
}