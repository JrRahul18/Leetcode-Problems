class Solution {
    public boolean canSortArray(int[] nums) {
        
        boolean check = true;
        for(int i=0; i<nums.length; i++){
            check = false;
            for(int j=0; j<nums.length - i -1; j++){
                
                if(nums[j]<=nums[j+1]){
                    continue;
                }
                else{
                    if(Integer.bitCount(nums[j]) == Integer.bitCount(nums[j+1])){
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                        check = true;
                    }
                    else{
                        return false;
                    }
                }
            }
            
            if(check == false) break;
        }
        
        return true;
    }
}