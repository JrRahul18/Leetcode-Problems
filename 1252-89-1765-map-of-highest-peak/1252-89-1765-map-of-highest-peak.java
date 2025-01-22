class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    static int []iArray ={0, 0, 1, -1};
    static int []jArray ={1, -1, 0, 0};

    public int[][] highestPeak(int[][] isWater) {
        int[][] storeAns = new int[isWater.length][isWater[0].length];

        for(int i=0; i<storeAns.length; i++){
            Arrays.fill(storeAns[i], -1);
        }
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<isWater.length; i++){
            for(int j=0; j<isWater[i].length; j++){
                if(isWater[i][j] == 1){
                    storeAns[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }

        while(!q.isEmpty()){
            Pair temp = q.peek();
            q.poll();

            for(int p=0; p<iArray.length; p++){
                int new_i = temp.i+iArray[p];
                int new_j = temp.j+jArray[p];
                if(new_i>=0 && new_i<isWater.length && new_j >=0 && new_j < isWater[0].length && storeAns[new_i][new_j] == -1){
                    storeAns[new_i][new_j] = storeAns[temp.i][temp.j]+1;
                    q.add(new Pair(new_i, new_j));
                }
            }
        }
        return storeAns;
        
    }
}