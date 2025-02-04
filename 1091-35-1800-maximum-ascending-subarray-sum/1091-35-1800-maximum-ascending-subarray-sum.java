class Solution {
    public int maxAscendingSum(int[] nums) {
        int finalAns = 0;
        int current = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i-1] < nums[i]){
                current +=nums[i];

            }
            else{
                finalAns = Math.max(finalAns, current);
                current = nums[i];
            }
        }
        return Math.max(finalAns, current);
    }
}