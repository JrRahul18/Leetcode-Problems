class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currentSum = nums[0], maxSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currentSum = Math.max(currentSum + nums[i], nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        currentSum = nums[0];
        int minSum = nums[0];
        for(int i=1; i<nums.length; i++){
            currentSum = Math.min(currentSum+nums[i], nums[i]);
            minSum = Math.min(minSum, currentSum);
        }

        minSum = Math.abs(minSum);

        return Math.max(maxSum, minSum);
        
    }
}