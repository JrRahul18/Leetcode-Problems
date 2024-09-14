class Solution {
    public int longestSubarray(int[] nums) {
        int max=0, finalAns = 0, count=0;
        
        for(int num: nums){
            if(num>max){
                max = num;
                finalAns=0;
                count=0;
            }
            
            
            if(max == num){
                count++;
            }
            else{
                count=0;
            }
            
            finalAns = Math.max(finalAns, count);
        }
        return finalAns;
    }
}