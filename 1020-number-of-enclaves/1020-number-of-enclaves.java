class Solution {
    static int[] xArray = {-1, 1, 0, 0};
    static int[] yArray = {0, 0, -1, 1};
    public void DFSTraversal(int i, int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;
        if(grid[i][j]==0)return;
        
        grid[i][j] = 0;
        for(int k=0; k<xArray.length; k++){
            DFSTraversal(i+xArray[k], j+yArray[k], grid);
        }
        
    }
    public int numEnclaves(int[][] grid) {
        int finalAns=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
                    if(grid[i][j] == 1){
                        DFSTraversal(i, j, grid);
                    }
                }
            }
        }
        for(int i=1; i<grid.length-1; i++){
            for(int j=1; j<grid[0].length-1; j++){
                if(grid[i][j]==1) finalAns++;
            }
        }
        return finalAns;
    }
}