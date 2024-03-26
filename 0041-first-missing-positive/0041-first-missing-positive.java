class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean checkOne = false;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                checkOne = true;
            }
            if(nums[i]<=0 || nums[i]>nums.length){
                nums[i]=1;
            }
        }
        if(checkOne == false) return 1;
        
        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i])-1;
            
            if(nums[idx] >=0){
                nums[idx] *= -1;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return nums.length+1;
        
    }
}