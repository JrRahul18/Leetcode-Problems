class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int finalAns = arr.length;
        int i=0, j=arr.length-1;
        
        while(j>=1 && arr[j]>=arr[j-1]){
            j--;
        }
        if(i==j) return 0;
        finalAns=j;
        
        while(i<j && (i==0 || arr[i]>=arr[i-1]) ){
            
            while(j<arr.length && arr[i]>arr[j] ){
                j++;
            }
            finalAns = Math.min(finalAns, j-i-1);
            i++;
        }
        return finalAns;
    }
}