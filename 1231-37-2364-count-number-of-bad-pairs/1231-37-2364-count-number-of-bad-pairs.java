class Solution {
    public long countBadPairs(int[] nums) {
        long finalAns = 0;
        // for(int i=0; i<nums.length; i++){
        //     nums[i] = i-nums[i];
        // }
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int curr = i - nums[i];

            int goodPairs = hmap.getOrDefault(curr, 0);

            finalAns += i - goodPairs;
            hmap.put(curr, hmap.getOrDefault(curr, 0) + 1);
        }
        return finalAns;
    }
}