class Solution {
    public String compressedString(String word) {
        String finalAns = "";
        
        int i=0;
        
        while(i<word.length()){
            int count=0;
            char ch = word.charAt(i);
            
            while(i<word.length() && count<9 && word.charAt(i)==ch){
                count++;
                i++;
            }
            finalAns+=count;
            finalAns+=ch;
        }
        return finalAns;
    }
}