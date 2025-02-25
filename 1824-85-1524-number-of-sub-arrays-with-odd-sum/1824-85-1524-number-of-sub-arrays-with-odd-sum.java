class Solution {
    static int mod = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int finalAns = 0;

        int[] pref = new int[arr.length];

        pref[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            pref[i] = pref[i-1] + arr[i];
        }

        int oddCount=0, evenCount=1;

        for(int i=0; i<pref.length; i++){
            if(pref[i]%2 != 0){
                finalAns = (finalAns + evenCount) % mod;
                oddCount++;
            }
            else{
                finalAns = (finalAns + oddCount) % mod;
                evenCount++;
            }
        }
        return finalAns;
    }
}