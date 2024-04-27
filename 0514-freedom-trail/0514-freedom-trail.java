class Solution {
    static int [][]dp;
    public int solve(int idx, int keyPointer, String ring, String key){
        if(keyPointer >= key.length()) return 0;
        if(dp[idx][keyPointer] != -1) return dp[idx][keyPointer];
        int ans = Integer.MAX_VALUE;
        
        for(int i=0; i<ring.length(); i++){
            if(ring.charAt(i) == key.charAt(keyPointer)){
                int steps = Math.min(Math.abs(i-idx), ring.length()-Math.abs(i-idx));
                ans = Math.min(ans, steps+1+solve(i, keyPointer+1, ring, key));
            }
        }
        return dp[idx][keyPointer] = ans;
    }
    public int findRotateSteps(String ring, String key) {
        dp = new int[ring.length()+1][key.length()+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, ring, key);
        
    }
}