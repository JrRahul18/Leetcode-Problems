class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minIndex=-1,  maxIndex=-1, outOfBound=-1;
        long finalAns=0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]<minK || nums[i]>maxK){
                outOfBound = i;
            }
            if(nums[i] == minK){
                minIndex=i;
            }
            if(nums[i]==maxK){
                maxIndex = i;
            }
            long min = Math.min(minIndex, maxIndex);
            long temp = min-outOfBound;
            if(temp>0){
                finalAns+=temp;
            }
            
        }
        return finalAns;
        
        
    }
}