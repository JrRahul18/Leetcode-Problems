class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int finalAns[] = new int[queries.length];
        int[] pref = new int[arr.length];
        pref[0] = arr[0];
        for(int i=1; i<pref.length; i++){
            pref[i] = pref[i-1] ^ arr[i];
        }
        
        for(int i=0; i<queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int val = pref[r] ^ (l==0 ? 0 : pref[l-1]);
            finalAns[i] = val;
        }
        return finalAns;
    }
}