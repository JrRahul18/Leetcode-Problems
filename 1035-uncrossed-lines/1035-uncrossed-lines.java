class Solution {
    static int [][]dp;
    public int solve(int idx1, int idx2, int[] nums1, int [] nums2){
        if(idx1==nums1.length || idx2 == nums2.length) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        if(nums1[idx1] == nums2[idx2]){
            ans1 = 1 + solve(idx1+1, idx2+1, nums1, nums2);
            ans2 = solve(idx1+1, idx2, nums1, nums2);
            ans3 = solve(idx1, idx2+1, nums1, nums2);
        }
        else{
            ans1 = solve(idx1+1, idx2, nums1, nums2);
            ans2 = solve(idx1, idx2+1, nums1, nums2);
        }
        // return Math.max(ans1, ans2);
        return dp[idx1][idx2] = Math.max(ans1, Math.max(ans2, ans3));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new int[nums1.length+1][nums2.length+1];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, nums1, nums2);
    }
}