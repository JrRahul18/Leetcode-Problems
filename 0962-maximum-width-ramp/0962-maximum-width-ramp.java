class Solution {
    public int maxWidthRamp(int[] nums) {
        int finalAns = 0;
        int [] maxRight = new int[nums.length];
        
        int temp = nums[nums.length-1];
        
        for(int i=maxRight.length-1; i>=0; i--){
            temp = Math.max(temp, nums[i]);
            maxRight[i] = temp;
        }
        
        int i=0, j=0;
        
        int ans = nums[0];
        while(j<maxRight.length){
            if(maxRight[j]>= nums[i]){
                finalAns = Math.max(finalAns, j-i);
                j++;
            }
            else{
                i++;
                
            }
        }
        return finalAns;
        
        
    }
}