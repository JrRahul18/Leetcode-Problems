class Solution {
    public int numTeams(int[] rating) {
        int finalAns = 0;
        
        for(int j=1; j<rating.length; j++){
            
            int lessCountBefore=0;
            int greaterCountBefore=0;
            
            int lessCountAfter=0;
            int greaterCountAfter=0;
            
            for(int i=0; i<j; i++){
                if(rating[i] < rating[j]){
                    lessCountBefore++;
                }
                else if(rating[i]>rating[j]){
                    greaterCountBefore++;
                }
            }
            
            for(int k=j+1; k<rating.length; k++){
                if(rating[k] < rating[j]){
                    lessCountAfter++;
                }
                else if(rating[k]>rating[j]){
                    greaterCountAfter++;
                }
            }
            finalAns += (lessCountBefore * greaterCountAfter) + (greaterCountBefore * lessCountAfter);
        }
        return finalAns;
    }
}