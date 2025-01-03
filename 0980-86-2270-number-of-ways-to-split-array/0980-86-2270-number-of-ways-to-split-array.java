class Solution {
    public int waysToSplitArray(int[] nums) {
        long total = 0;
        int finalAns=0;
        for(int num: nums){
            total+=num;
        }
        
        long left=0, right=0;

        for(int i=0; i<nums.length-1; i++){
            left+=nums[i];
            right=total-left;
            if(left >= right) finalAns++;
        }
        
        return finalAns;
    }
}