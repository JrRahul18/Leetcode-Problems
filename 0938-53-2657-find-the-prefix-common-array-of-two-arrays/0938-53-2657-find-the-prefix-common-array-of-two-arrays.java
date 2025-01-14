class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] finalAns = new int[A.length];

        HashMap<Integer, Integer> hmap = new HashMap<>();

        int sum=0;
        for(int i=0; i<A.length; i++){
            hmap.put(A[i], hmap.getOrDefault(A[i], 0) + 1);
            if(hmap.get(A[i]) == 2) sum++;

            hmap.put(B[i], hmap.getOrDefault(B[i], 0) + 1);
            if(hmap.get(B[i]) == 2) sum++;
            
            finalAns[i]=sum;
        }
        return finalAns;
    }
}