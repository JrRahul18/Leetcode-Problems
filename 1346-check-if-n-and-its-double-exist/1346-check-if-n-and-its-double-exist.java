class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hset = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            if(hset.contains(arr[i]*2)) return true;
            if(arr[i]%2 == 0 && hset.contains(arr[i]/2))return true;
            
            hset.add(arr[i]);
        }
        
        return false;
    }
}