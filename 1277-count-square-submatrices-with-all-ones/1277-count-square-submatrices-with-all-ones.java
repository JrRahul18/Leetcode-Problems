class Solution {
    static int dp[][];
    public int solve(int i, int j, int[][] matrix){
        if(i>=matrix.length || j>=matrix[0].length || matrix[i][j] == 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int ans1 = solve(i+1, j, matrix);
        int ans2 = solve(i+1, j+1, matrix);
        int ans3 = solve(i, j+1, matrix);
        
        return dp[i][j]= 1 + Math.min(ans1, Math.min(ans2, ans3));
    }
    public int countSquares(int[][] matrix) {
        int finalAns = 0;
        dp = new int[matrix.length+1][matrix[0].length + 1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    finalAns+=solve(i, j, matrix);
                }
            }
        }
        return finalAns;
    }
}