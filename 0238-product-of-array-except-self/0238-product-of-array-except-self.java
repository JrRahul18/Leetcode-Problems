class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[]leftPref = new int[nums.length];
        int[]rightPref = new int[nums.length];
        
        leftPref[0] = 1;
        rightPref[nums.length-1] = 1;
        for(int i=1; i<leftPref.length; i++){
            leftPref[i] = leftPref[i-1] * nums[i-1];
        }
        
        for(int i= rightPref.length-2; i>=0; i--){
            rightPref[i] = rightPref[i+1]*nums[i+1];
        }
        
        for(int i=0; i<nums.length; i++){
            nums[i] = leftPref[i]*rightPref[i];
        }
        return nums;
    }
}