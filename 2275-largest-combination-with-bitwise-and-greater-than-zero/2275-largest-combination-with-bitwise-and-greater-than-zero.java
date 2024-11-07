class Solution {
    public int largestCombination(int[] candidates) {
        int finalAns = 0;
        
        for(int i=0; i<32; i++){
            int countBits = 0;
            for(int num: candidates){
                if( (num & (1 << i)) > 0){
                    countBits++;
                }
            }
            
            finalAns = Math.max(finalAns, countBits);
        }
        
        return finalAns;
    }
}