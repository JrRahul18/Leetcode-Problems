class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            maxVal = Math.max(maxVal, nums[i]);
        }
        int i=0, j=0;
        long finalAns=0;
        int count=0;
        
        while(j<nums.length){
            if(nums[j] == maxVal) count++;
            while(count>=k){
                finalAns+=nums.length-j;
                if(nums[i] == maxVal){
                    count--;
                }
                i++;
            }
            j++;
        }
        return finalAns;
    }
}