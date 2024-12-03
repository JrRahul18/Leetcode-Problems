class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder finalAns = new StringBuilder();
        int p=0;
        for(int i=0; i<s.length(); i++){
            if(p<spaces.length && i==spaces[p]){
                finalAns.append(" ");
                p++;
            }
            finalAns.append(s.charAt(i));
        }
        return finalAns.toString();
    }
}