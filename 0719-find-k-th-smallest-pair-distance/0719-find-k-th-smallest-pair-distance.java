class Solution {
    public boolean countPairs(int target, int[]nums, int k){
        int count = 0;
        int j=0;
        for(int i=0; i<nums.length; i++){
            while(j<nums.length && nums[j]-nums[i] <= target){
                j++;
            }
            count +=j-i-1;
            if(count>=k) return true;
        }
        return false;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length-1]-nums[0];
        while(left < right){
            int mid = left + (right-left)/2;
            if(countPairs(mid, nums, k)== true){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}