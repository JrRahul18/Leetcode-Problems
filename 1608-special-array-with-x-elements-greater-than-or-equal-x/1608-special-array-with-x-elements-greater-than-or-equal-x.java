class Solution {
    public int find(int target, int[]nums){
        int l = 0, r = nums.length;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid] >= target){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        
        int l = 0, r = nums.length;
        while(l<=r){
            int mid = l+(r-l)/2;
            
            int lowIdx = find(mid, nums);
            if(nums.length - lowIdx == mid) return mid;
            else if(nums.length - lowIdx >mid) l=mid+1;
            else r = mid-1;
        }
        return -1;
        
    }
}