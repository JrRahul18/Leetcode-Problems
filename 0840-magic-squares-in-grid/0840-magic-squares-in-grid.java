class Solution {
    public boolean isMagic(int x, int y, int[][] grid){
        int[] check  = new int[10];
        
        for(int i=x; i<x+3; i++){
            for(int j=y; j<y+3; j++){
                if(grid[i][j] <=0 || grid[i][j] >9){
                    return false;
                }else{
                    check[grid[i][j]]++;
                }
            }
        }
        
        for(int i=1; i<check.length; i++){
            if(check[i] == 0 || check[i]>1) return false;
        }
        int sum = grid[x][y]+grid[x][y+1]+grid[x][y+2];
        
        for(int i=x; i<x+3; i++){
            if(grid[i][y]+grid[i][y+1]+grid[i][y+2] != sum) return false;
        }
        for(int j=y; j<y+3; j++){
            if(grid[x][j]+grid[x+1][j]+grid[x+2][j] != sum) return false;
        }
        if(grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2] != sum) return false;
        
        if(grid[x][y+2] + grid[x+1][y+1] + grid[x+2][y] != sum) return false;
        
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int finalAns = 0;
        if(grid.length <3 || grid[0].length < 3) return finalAns;
        for(int i=0; i<grid.length-2; i++){
            for(int j=0; j<grid[0].length-2; j++){
                if(isMagic(i, j, grid) == true){
                  finalAns++;  
                }
            }
        }
        return finalAns;
    }
}