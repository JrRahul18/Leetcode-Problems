class Solution {
    public int countServers(int[][] grid) {
        int finalAns=0;
        int[] countCol = new int[grid[0].length];
        int[] storeIdx = new int[grid.length];
        Arrays.fill(storeIdx, -1);

        for(int i=0; i<grid.length; i++){
            int countOnes=0;
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    countOnes++;
                    countCol[j]++;
                    storeIdx[i]=j;
                }
            }
            if(countOnes > 1){
                finalAns+=countOnes;
                storeIdx[i]=-1;
            }
        }

        for(int i=0; i<storeIdx.length; i++){
            if(storeIdx[i] == -1) continue;

            int idx = storeIdx[i];
            if(countCol[idx] > 1){
                finalAns++;
            }
        }
        return finalAns;
    }
}