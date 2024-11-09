class Solution {
    public long minEnd(int n, int x) {
        long finalAns = (long)x;
        
        for(int i=1; i<n; i++){
            finalAns = (finalAns+1) | x; 
        }
        return finalAns;
    }
}