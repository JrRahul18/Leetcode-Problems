class Solution {
    static void solve(int[] nums, int idx, List<Integer> temp, List<List<Integer>> finalAns){
        if(idx == nums.length){
            finalAns.add(new ArrayList(temp));
            return;
        }

        temp.add(nums[idx]);
        solve(nums, idx+1, temp, finalAns);

        temp.remove(temp.size()-1);

        solve(nums, idx+1, temp, finalAns);

    }
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> finalAns = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        solve(nums, 0, temp, finalAns);
        return finalAns;
    }
}