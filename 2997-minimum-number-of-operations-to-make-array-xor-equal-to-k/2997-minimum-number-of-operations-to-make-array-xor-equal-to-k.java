class Solution {
    public int minOperations(int[] nums, int k) {
        int finalAns=0;
        int xorResult = 0;
        for(int num: nums){
            xorResult = xorResult ^ num;
        }
        if(xorResult == k) return 0;
        
        int count = xorResult ^ k;
        
        while(count >0){
            finalAns++;
            count = count & (count-1);
        }
        return finalAns;
    }
}