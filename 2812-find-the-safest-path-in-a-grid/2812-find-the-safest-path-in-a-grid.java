class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] xTraverse = {1, 0, -1, 0};
    static int[] yTraverse = {0, 1, 0, -1};
    
    
    public boolean checkDistance(int mid, int[][] thiefGrid){
        
        Queue<Pair> q = new LinkedList<>();
        boolean[][] checkVisited = new boolean[thiefGrid.length][thiefGrid[0].length];
        for(int i=0; i<thiefGrid.length; i++){
            Arrays.fill(checkVisited[i], false);
        }
        
        q.add(new Pair(0, 0));
        checkVisited[0][0] = true;
        if(thiefGrid[0][0]<mid) return false;
        
        while(!q.isEmpty()){
            Pair temp = q.peek();
            q.poll();
            int x = temp.x;
            int y = temp.y;
            
            if(x == thiefGrid.length-1 && y == thiefGrid.length -1){
                return true;
            }
            for(int p =0; p<xTraverse.length; p++){
                 if(x+xTraverse[p] >=0 && x+xTraverse[p]<thiefGrid.length && y+yTraverse[p]>=0 && y+yTraverse[p]<thiefGrid[0].length && checkVisited[x+xTraverse[p]][y+yTraverse[p]] != true){
                     if(thiefGrid[x+xTraverse[p]][y+yTraverse[p]] < mid){
                         continue;
                     }
                     q.add(new Pair(x+xTraverse[p], y+yTraverse[p]));
                     checkVisited[x+xTraverse[p]][y+yTraverse[p]] = true;
                     
                 }
            }
        }
        return false;
        
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int finalAns = 0;
        // int[][]grid = new int[list.size()][list.size()];
        
        int[][] thiefGrid = new int[grid.size()][grid.size()];
        boolean[][] checkVisited = new boolean[grid.size()][grid.size()];
        
        for(int i=0; i<thiefGrid.length; i++){
            Arrays.fill(thiefGrid[i], -1);
            Arrays.fill(checkVisited[i], false);
        }
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid.size(); j++){
                if(grid.get(i).get(j) == 1){
                    q.add(new Pair(i, j));
                    checkVisited[i][j] = true;
                }
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                Pair temp = q.peek();
                q.poll();
                int x = temp.x;
                int y = temp.y;
                
                thiefGrid[x][y] = count;
                
                for(int p=0; p<xTraverse.length; p++){
                    if(x+xTraverse[p] >=0 && x+xTraverse[p]<grid.size() && y+yTraverse[p]>=0 && y+yTraverse[p]<grid.size() && checkVisited[x+xTraverse[p]][y+yTraverse[p]] == false){
                        q.add(new Pair(x+xTraverse[p], y+yTraverse[p]));
                        checkVisited[x+xTraverse[p]][y+yTraverse[p]] = true;
                    }
                }
            }
            count++;
        }
        
        int left = 0;
        int right = 400;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(checkDistance(mid, thiefGrid) == true){
                finalAns = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return finalAns;
    }
}