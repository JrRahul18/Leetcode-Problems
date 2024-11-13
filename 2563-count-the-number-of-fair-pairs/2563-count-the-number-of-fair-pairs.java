class Solution {
    static long countLower(int[] nums, int target){
        long ans =0;
        int i=0, j=nums.length-1;
        
        while(i<=j){
            if(nums[i]+nums[j]<target){
                ans+=j-i;
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        long finalAns = 0;
        
        Arrays.sort(nums);
        
        // int i=0, j=nums.length-1;
        
        long l=countLower(nums, lower);
        long r=countLower(nums, upper+1);
        
        return r-l;
        
        
    }
}