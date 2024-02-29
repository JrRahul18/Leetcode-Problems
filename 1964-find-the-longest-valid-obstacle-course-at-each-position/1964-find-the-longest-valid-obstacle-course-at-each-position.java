class Solution {
    public int findIdx(int low, int high, int value, List<Integer>storeLIS){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(value>=storeLIS.get(mid)){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
        
    }
    //In storeLIS,
    // the index stores the length of subsequence 
    //value at that index stores the last minimum value for the subsequence of length equal to the index
    
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] finalAns = new int[obstacles.length];
        List<Integer> storeLIS = new ArrayList<>();
        // int[] storeLIS = new int[obstacles.length];
        int highIdx = 0;

        for(int i=0; i<obstacles.length; i++){
            int idx = findIdx(0, storeLIS.size()-1, obstacles[i], storeLIS);
            if(idx == storeLIS.size()){
                storeLIS.add(obstacles[i]);
            }
            else{
                storeLIS.set(idx, obstacles[i]);
            }
            finalAns[i] = idx+1;
        }
        return finalAns;

    }
}