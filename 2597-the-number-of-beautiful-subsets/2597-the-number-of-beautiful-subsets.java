class Solution {
    int finalAns;
    public void solve(int idx, int[]nums, int k, HashMap<Integer, Integer> hmap){
        if(idx == nums.length){
            finalAns++;
            return;
        }
        solve(idx+1, nums, k, hmap);
        if(!hmap.containsKey(nums[idx]-k) && !hmap.containsKey(nums[idx]+k)){
            hmap.put(nums[idx], hmap.getOrDefault(nums[idx], 0)+1);
            solve(idx+1, nums, k, hmap);
            hmap.put(nums[idx], hmap.get(nums[idx])-1);
            if(hmap.get(nums[idx]) == 0 ){
                hmap.remove(nums[idx]);
            }
        }
    }
    public int beautifulSubsets(int[] nums, int k) {
        finalAns = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        solve(0, nums, k, hmap);
        return finalAns-1;
        
        
    }
}