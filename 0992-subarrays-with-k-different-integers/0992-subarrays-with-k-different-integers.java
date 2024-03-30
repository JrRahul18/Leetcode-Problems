class Solution {
    static int slidingWindow(int[] nums, int k){
        int count=0;
        int i=0, j=0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        
        while(j<nums.length){
            hmap.put(nums[j], hmap.getOrDefault(nums[j], 0)+1);
            while(hmap.size()>k){
                hmap.put(nums[i], hmap.get(nums[i])-1);
                if(hmap.get(nums[i]) ==0){
                    hmap.remove(nums[i]);
                }
                i++;
            }
            count +=(j-i+1);
            j++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindow(nums, k)-slidingWindow(nums, k-1);
    }
}