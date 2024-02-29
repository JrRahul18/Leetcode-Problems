class Solution {
    static long[]dp;
    public long solve(int idx, int[][] questions){
        if(idx>=questions.length) return 0;
        if(dp[idx] != -1) return dp[idx];

        long ans1=0;
        long ans2=0;
        ans1 = questions[idx][0] + solve(idx+questions[idx][1]+1, questions);
        ans2 = solve(idx+1, questions);
        return dp[idx] = Math.max(ans1, ans2);
    }
    public long mostPoints(int[][] questions) {
        dp = new long[questions.length+1];
        Arrays.fill(dp, -1);

        return solve(0, questions);
    }
}