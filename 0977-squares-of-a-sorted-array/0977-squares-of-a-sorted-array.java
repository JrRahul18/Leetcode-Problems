class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] finalAns = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i]*nums[i];
        }
        int i=0;
        int j=nums.length-1;
        for(int k=nums.length-1; k>=0; k--){
            if(nums[i]>nums[j]){
                finalAns[k] = nums[i];
                i++;
            }
            else{
                finalAns[k] = nums[j];
                j--;
            }
        }
        return finalAns;
    }
}