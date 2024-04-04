class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int finalAns = 0;
        for(char ch: s.toCharArray()){
            if(ch == '(') count++;
            else if(ch == ')') count--;
            
            finalAns = Math.max(finalAns, count);
        }
        return finalAns;
    }
}