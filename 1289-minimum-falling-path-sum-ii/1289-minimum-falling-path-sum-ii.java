class Solution {
    static int[][]dp;
    static int solve(int i, int j, int[][] grid){
        // if(j<0 || j>=grid[0].length) return 10000000;

        if(i == grid.length-1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
        for(int col = 0; col<grid[0].length; col++){
            if(col == j) continue;
            ans = Math.min(ans, grid[i][j] + solve(i+1, col, grid));
        }

        return dp[i][j] = ans;

    }
    public int minFallingPathSum(int[][] grid) {
        dp = new int[201][201];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int finalAns = Integer.MAX_VALUE;

        for(int i = 0; i<1; i++){
            for(int j = 0; j<grid[0].length; j++){
                finalAns = Math.min(finalAns, solve(i, j, grid));
            }
        }

        return finalAns;
        
    }
}