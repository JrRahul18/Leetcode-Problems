class Solution {
    static int mod = 1000000007;
    static int[]dp;
    static int low, high, zero, one;

    static int solve(int current){

        if(current > high) return 0;

        if(dp[current] != -1) return dp[current];

        int takeCurrent=0;
        if(current >=low && current<=high){
            takeCurrent++;
        }

        int take0=0, take1=0;

        take0=solve(current+zero);
        take1=solve(current+one);

        return dp[current] = (take0 + take1 + takeCurrent)%mod;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        this.low=low;
        this.high=high;
        this.zero=zero;
        this.one=one;

        dp=new int[high+1];
        Arrays.fill(dp, -1);
        return solve(0);
    }
}