class Solution {
    static long[][]dp;
//     static long solve(int row, int col, int[][] points){
        
//         if(row ==points.length) return 0;
        
//         if(dp[row][col] != -1) return dp[row][col];
        
//         long ans = Long.MIN_VALUE;
//         for(int j=0; j<points[row].length; j++){
//             long temp = points[row][j] - Math.abs(col-j) + solve(row+1, j, points);
            
//             ans = Math.max(ans, temp);
//         }
//         return dp[row][col] = ans;
//     }
    public long maxPoints(int[][] points) {
        long finalAns = Long.MIN_VALUE;
        dp = new long[points.length][points[0].length];
        
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int j=0; j<points[0].length; j++){
            dp[0][j] = points[0][j]; 
        }
        for(int i=1; i<points.length; i++){
            long[] leftDP = new long[points[i].length];
            long[] rightDP = new long[points[i].length];
            leftDP[0] = dp[i-1][0];
            rightDP[points[i].length-1] = dp[i-1][points[i].length-1];
            
            for(int p=1; p<leftDP.length; p++){
                leftDP[p] = Math.max(dp[i-1][p], leftDP[p-1]-1);
            }
            
            for(int p=points[i].length-2; p>=0; p--){
                rightDP[p] = Math.max(dp[i-1][p], rightDP[p+1]-1);
            }
            
            for(int p=0; p<leftDP.length; p++){
                dp[i][p] = points[i][p] + Math.max(leftDP[p], rightDP[p]);
            }
        }
        for(int i=0; i<dp[0].length; i++){
            finalAns = Math.max(finalAns, dp[points.length-1][i]);
        }
        return finalAns;
        
        
        
        
        
        // long finalAns = Long.MIN_VALUE;
        // for(int i=0; i<points[0].length; i++){
        //     finalAns = Math.max(finalAns, points[0][i] + solve(1, i, points));
        // }
        // return finalAns;
    }
}