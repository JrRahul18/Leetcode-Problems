class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, 1);
        int finalAns =0;
        int prefSum=0;
        for(int i=0; i<nums.length; i++){
            prefSum+=nums[i];
            int find = prefSum-goal;
            finalAns+=hmap.getOrDefault(find, 0);
            hmap.put(prefSum, hmap.getOrDefault(prefSum, 0) + 1);
        }
        return finalAns;
        
    }
}