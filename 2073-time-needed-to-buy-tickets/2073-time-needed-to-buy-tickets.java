class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int finalAns = 0;
        for(int i=0; i<tickets.length; i++){
            if(tickets[i]< tickets[k]){
                finalAns+=tickets[i];
            }
            else finalAns+=tickets[k];
            
            if(i>k && tickets[i]>=tickets[k]){
                finalAns--;
            }
        }
        return finalAns;
    }
}