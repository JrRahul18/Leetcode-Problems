class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long finalAns=0;
        long[] inDegree = new long[n];
        for(int[] road: roads){
            inDegree[road[0]]++;
            inDegree[road[1]]++;
        }
        Arrays.sort(inDegree);
        for(int i=0; i<inDegree.length; i++){
            finalAns += inDegree[i] *(i+1);
        }
        return finalAns;
    }
}