class Solution {
    public String makeFancyString(String s) {
        StringBuilder finalAns = new StringBuilder();
        
        for(char ch: s.toCharArray()){
            int len = finalAns.length();
            if(len<2 || !(finalAns.charAt(len-1)==ch && finalAns.charAt(len-2)==ch ) ){
                finalAns.append(ch);
            }

        }
        return finalAns.toString();
    }
}

