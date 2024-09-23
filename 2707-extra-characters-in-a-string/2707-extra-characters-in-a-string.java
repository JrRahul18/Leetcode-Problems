class Solution {
    static int[] dp;
    public int solve(int idx, String s, HashSet<String> hset){
        
        if(idx >=s.length()) return 0;
        
        if(dp[idx] != -1) return dp[idx];
        
        String temp = "";
        int ans = s.length();
        
        for(int i = idx; i<s.length(); i++){
            temp+=s.charAt(i);
            
            int count = hset.contains(temp) ? 0: temp.length();
            
            int next = solve(i+1, s, hset);
            
            ans = Math.min(ans, count+next);
        }
        return dp[idx] = ans;
    }
    public int minExtraChar(String s, String[] dictionary) {
        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        
        HashSet<String> hset = new HashSet<>();
        
        for(String str: dictionary){
            hset.add(str);
        }
        
        return solve(0, s, hset);
        
    }
}