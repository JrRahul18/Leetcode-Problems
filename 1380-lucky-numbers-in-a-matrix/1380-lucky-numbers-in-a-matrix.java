class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> finalAns = new ArrayList<>();
        HashSet<Integer> hset = new HashSet<>();
        for(int i=0; i<matrix.length; i++){
            int minVal = Integer.MAX_VALUE;
            for(int j=0; j<matrix[0].length; j++){
                minVal=Math.min(minVal, matrix[i][j]);
            }
            hset.add(minVal);
        }
        
        for(int i=0; i<matrix[0].length; i++){
            int maxVal = Integer.MIN_VALUE;
            for(int j=0; j<matrix.length; j++){
                maxVal = Math.max(maxVal, matrix[j][i]);
            }
            if(hset.contains(maxVal)){
                finalAns.add(maxVal);
            }
        }
        return finalAns;
        
    }
}