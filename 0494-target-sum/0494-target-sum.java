class Solution {
    static HashMap<String, Integer> dp;
    public int solve(int idx, int[] nums, int target, int current){
        if(idx >= nums.length){
            if(target == current){
                return 1;
            }
            else return 0;
        }
        
        String str = idx+"_"+current;
        if(dp.containsKey(str)){
            return dp.get(str);
        }
        int ans1=0, ans2=0;
        
        ans1 = solve(idx+1, nums, target, current+nums[idx]);
        ans2 = solve(idx+1, nums, target, current-nums[idx]);
        
        dp.put(str, ans1+ans2);
        return ans1+ans2;
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        
        dp = new HashMap<>();
        return solve(0, nums, target, 0);
    }
}