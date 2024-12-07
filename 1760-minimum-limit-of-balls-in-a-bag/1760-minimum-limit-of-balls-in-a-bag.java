class Solution {
    static boolean check(int target, int[] nums, int maxOperations){
        int count=0;
        
        for(int num: nums){
            count+= num/target;
            if(num%target == 0){
                count--;
            }
            if(count> maxOperations) return false;
        }
        return true;
        
    }
    public int minimumSize(int[] nums, int maxOperations) {
    
        int finalAns=0;
        int left=1, right = 0;
        
        for(int i=0; i<nums.length; i++){
            right = Math.max(right, nums[i]);
        }
        
        while(left <= right){
            int mid = left + (right-left)/2;
            
            if(check(mid, nums, maxOperations)==true){
                finalAns=mid;
                right = mid-1;
            }
            else{
                left=mid+1;
            }
            
        }
        return finalAns;
    }
}