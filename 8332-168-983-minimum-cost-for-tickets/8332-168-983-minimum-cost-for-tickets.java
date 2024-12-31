class Solution {
    static int[]dp;
    static int findIdx(int idx, int[] days, int [] costs, int passDays){
        int nextDays = days[idx] + passDays;
        while(idx<days.length && days[idx] < nextDays) idx++;
        return idx;
    }
    static int solve(int idx, int[] days, int[] costs){
        if(idx>=days.length){
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];
        int take1;
        int take2;
        int take3;
        int temp_idx;

        //1-Day Pass
        temp_idx = findIdx(idx, days, costs, 1);
        take1 = costs[0] + solve(temp_idx, days, costs);

        //7-Days Pass
        temp_idx = findIdx(idx, days, costs, 7);
        take2 = costs[1] + solve(temp_idx, days, costs);

        //30-Days Pass
        temp_idx = findIdx(idx, days, costs, 30);
        take3 = costs[2] + solve(temp_idx, days, costs);

        return dp[idx] = Math.min(take1, Math.min(take2, take3));
    }

    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[366];
        Arrays.fill(dp, -1);
        return solve(0, days, costs);   
    }
}