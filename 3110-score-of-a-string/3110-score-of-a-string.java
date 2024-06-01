class Solution {
    public int scoreOfString(String s) {
        int finalAns=0;
        for(int i=0; i<s.length()-1; i++){
            finalAns+=Math.abs(s.charAt(i)-s.charAt(i+1));
        }
        return finalAns;
    }
}