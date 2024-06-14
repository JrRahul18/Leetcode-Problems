class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int finalAns = 0, nextMax=0;
        for(int num: nums){
            nextMax = Math.max(nextMax, num);
            finalAns +=nextMax-num;
            nextMax++;
        }
        return finalAns;
        
    }
}