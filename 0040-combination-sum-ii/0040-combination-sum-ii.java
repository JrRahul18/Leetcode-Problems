class Solution {
    List<List<Integer>> finalAns;
    public void solve(int idx, int[] candidates, int target, List<Integer> current ){
        if(target < 0)return;
        if(target == 0){
            finalAns.add(new ArrayList(current));
            return;
        }
        for(int i = idx; i<candidates.length; i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            current.add(candidates[i]);
            solve(i+1, candidates, target-candidates[i], current);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        finalAns = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        Arrays.sort(candidates);
        solve(0, candidates, target, current);
        return finalAns;
    }
}