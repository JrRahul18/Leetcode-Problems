class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] finalAns = new int[rowSum.length][colSum.length];
        for(int i=0; i<rowSum.length; i++){
            for(int j=0; j<colSum.length; j++){
                if(rowSum[i]==0 || colSum[j]==0) continue;
                
                if(rowSum[i]<colSum[j]){
                    finalAns[i][j] = rowSum[i];
                    rowSum[i]=0;
                    colSum[j]=colSum[j]-finalAns[i][j];
                }
                else{
                    finalAns[i][j] = colSum[j];
                    colSum[j]=0;
                    rowSum[i]=rowSum[i]-finalAns[i][j];
                }
            }
        }
        return finalAns;
    }
}