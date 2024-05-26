class Solution {
    static int mod = 1000000007;
    static int dp[][][];
    public int solve(int idx, int n, int absentCount, int lateCount){        
        if(absentCount >=2 || lateCount >=3){
            return 0;
        }
        if(idx == n) return 1;
        
        if(dp[idx][absentCount][lateCount] != -1) return dp[idx][absentCount][lateCount];
        
        int ans1=0, ans2=0, ans3=0;
        
        ans1 = solve(idx+1, n, absentCount, 0)%mod;
        ans2 = solve(idx+1, n, absentCount+1, 0)%mod;
        ans3 = solve(idx+1, n, absentCount, lateCount+1)%mod;
        
        return dp[idx][absentCount][lateCount]=((ans1+ans2)%mod +ans3)%mod;
        
    }
    public int checkRecord(int n) {
        dp= new int[n+1][2][3];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, n, 0, 0);
        
    }
}