class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long finalAns=0;
        Arrays.sort(happiness);
        int count = 0;
        int i=happiness.length-1;
        while(k>0){
            if(happiness[i]-count<0) break;
            finalAns+=happiness[i]-count;
            count++;
            i--;
            k--;
        }
        return finalAns;
        
    }
}