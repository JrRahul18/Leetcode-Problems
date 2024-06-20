class Solution {
    public boolean isCheck(int mid, int[]position, int m){
        int last = position[0];
        int count = 1;
        
        for(int i=1; i<position.length; i++){
            if(position[i]-last >= mid){
                last = position[i];
                count++;
            }
            if(count == m) return true;
            
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int finalAns=-1;
        int left = 1;
        int right = position[position.length-1] - position[0];
        
        while(left<=right){
            int mid = left + (right-left)/2;
            if(isCheck(mid, position, m)){
                finalAns = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return finalAns;
    }
}