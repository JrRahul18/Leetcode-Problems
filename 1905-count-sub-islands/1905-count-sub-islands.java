class Solution {
    static int[] xArray = {-1, 0, 1, 0};
    static int[] yArray = {0, 1, 0, -1};
    public boolean dfs(int i, int j, int[][]grid1, int[][] grid2){
        if(i <0 || i>=grid1.length || j<0 || j>=grid1[0].length){
            return true;
        }
        if(grid2[i][j] != 1){
            return true;
        }
        grid2[i][j] = -1;
        
        boolean ans = false;
        if(grid1[i][j] == 1) ans = true;
        
        
        for(int p=0; p<xArray.length; p++){
            ans = ans & dfs(i+yArray[p], j+xArray[p], grid1, grid2);
        }
        return ans;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int finalAns = 0;
        for(int i=0; i<grid2.length; i++){
            for(int j=0; j<grid2[i].length; j++){
                if(grid2[i][j] == 1 && dfs(i, j, grid1, grid2)){
                    finalAns++;
                }
            }
        }
        return finalAns;
    }
}