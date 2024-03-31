class Solution {
    static int slidingWindow(int[] nums, int k){
        int i=0, j=0, finalAns=0, count=0;
        while(j<nums.length){
            if(nums[j]%2 != 0) count++;
            while(count>k){
                if(nums[i]%2 != 0) count--;
                i++;
            }
            finalAns+=j-i+1;
            j++;
        }
        return finalAns;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return (slidingWindow(nums, k)- slidingWindow(nums, k-1));
    }
}