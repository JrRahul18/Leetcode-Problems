class Solution {
    int mod = 1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        int finalAns = 0;
        List<Integer> lst = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int current = 0;
            for(int j = i; j<nums.length; j++){
                current+=nums[j];
                lst.add(current);
            }
        }
        Collections.sort(lst);
        for(int i=left-1; i<right; i++){
            finalAns = (finalAns + lst.get(i)) %mod;
        }
        return finalAns;
    }
}