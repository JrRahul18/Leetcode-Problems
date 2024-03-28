class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int finalAns = 0;
        
        int i=0, j=0;
        while(j<nums.length){
            hmap.put(nums[j], hmap.getOrDefault(nums[j], 0)+1);
            
            while(hmap.get(nums[j])>k){
                hmap.put(nums[i], hmap.getOrDefault(nums[i], 0)-1);
                i++;
            }
            finalAns = Math.max(finalAns, j-i+1);
            j++;
        }
        return finalAns;
    }
}