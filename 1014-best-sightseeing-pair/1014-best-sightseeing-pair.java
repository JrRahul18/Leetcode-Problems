class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int[] prefMax = new int[values.length];
        int finalAns = 0;
        prefMax[0]=values[0]+0;
        
        for(int i=1; i<values.length; i++){
            prefMax[i] = Math.max(values[i]+i, prefMax[i-1]);
        }
        
        for(int j=1; j<values.length; j++){
            finalAns = Math.max(prefMax[j-1] + (values[j]-j), finalAns );
        }
        return finalAns;
    }
}