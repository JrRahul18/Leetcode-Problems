class Solution {
    static int dp[][];
    public int solve(int i, int j, int[][]grid){
        
        if(i>=grid.length || j>=grid[0].length || i<0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];

        int ans1 =0, ans2=0, ans3=0;
        
        if(i-1>=0 && j+1<grid[0].length && grid[i][j] < grid[i-1][j+1]){
            ans1 = 1 + solve(i-1, j+1, grid);
        }
        
        if(j+1<grid[0].length && grid[i][j] < grid[i][j+1]){
            ans2 = 1 + solve(i, j+1, grid);
        }
        
        if(i+1<grid.length && j+1<grid[0].length && grid[i][j] < grid[i+1][j+1]){
            ans3 = 1 + solve(i+1, j+1, grid);
        }
            
            
        return dp[i][j] = Math.max(ans1, Math.max(ans2, ans3));
    }
    public int maxMoves(int[][] grid) {
        int finalAns = 0;
        dp = new int[grid.length+1][grid[0].length+1];
        
        for(int i=0; i<grid.length; i++){
            Arrays.fill(dp[i], -1);
        }
        
        for(int i=0; i<grid.length; i++){
            finalAns = Math.max(finalAns, solve(i, 0, grid));
        }
        return finalAns;
    }
}