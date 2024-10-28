class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> hmap = new HashMap<>();
        
        int finalAns = 0;
        for(int i=0; i<nums.length; i++){
            int root = (int) Math.sqrt(nums[i]);

            if(root * root == nums[i] && hmap.containsKey(root)){
                
                hmap.put(nums[i], hmap.get(root)+1);

            }
            else{
                hmap.put(nums[i], 1);
            }
            
            finalAns = Math.max(finalAns, hmap.get(nums[i]));
        }
        if(finalAns < 2) return -1;
        return finalAns;
    }
}