class Solution {
    static int[] iArray = {0, 1, 0, -1};
    static int[] jArray = {1, 0, -1, 0};

    static int dfs(int i, int j, int[][] grid, int idx){

        grid[i][j] = idx;
        int len=1;
        for(int p=0; p<iArray.length; p++){
            int ni = i+iArray[p];
            int nj = j+jArray[p];

            if(ni>=0 && ni<grid.length && nj>=0 && nj<grid[0].length && grid[ni][nj] == 1){
                len+=dfs(ni, nj, grid, idx);
            }
        }
        return len;
    }
    public int largestIsland(int[][] grid) {
        int finalAns = 0;

        HashMap<Integer, Integer> idxMap = new HashMap<>();
        int idx = 2;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    int len = dfs(i, j, grid, idx);
                    finalAns = Math.max(finalAns, len);
                    idxMap.put(idx, len);
                    idx++;
                }
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> hset = new HashSet<>();
                    for(int p=0; p<iArray.length; p++){
                        int ni = i + iArray[p];
                        int nj = j + jArray[p];

                        if(ni>=0 && ni<grid.length && nj>=0 && nj<grid[0].length && grid[ni][nj] != 0 ){
                            hset.add(grid[ni][nj]);
                        }
                    }

                    int sum = 1;
                    for(int id: hset){
                        sum+=idxMap.get(id);
                    }
                    finalAns = Math.max(finalAns, sum);
                }
            }
        }

        return finalAns;
    }
}