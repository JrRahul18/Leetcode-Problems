class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0){
            return arr;
        }
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr2);
        hmap.put(arr2[0], 1);
        
        int rank=2;
        for(int i=1; i<arr2.length; i++){
            if(arr2[i] != arr2[i-1]){
                hmap.put(arr2[i], rank);
                rank++;
            }
        }
        for(int i=0; i<arr.length; i++){
            arr[i] = hmap.get(arr[i]);
        }
        return arr;
    }
}