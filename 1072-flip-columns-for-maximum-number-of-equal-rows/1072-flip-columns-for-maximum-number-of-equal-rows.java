class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int finalAns=0;
        
        for(int[] row: matrix){
            int[] inverted = new int[matrix[0].length];
            for(int i=0; i<row.length; i++){
                inverted[i] = 1-row[i];
            }
            int count=0;
            for(int[] r: matrix){
                if(Arrays.equals(row, r) || Arrays.equals(r, inverted)){
                    count++;
                }
            }
            
            finalAns = Math.max(finalAns, count);
        }
        return finalAns;
    }
}