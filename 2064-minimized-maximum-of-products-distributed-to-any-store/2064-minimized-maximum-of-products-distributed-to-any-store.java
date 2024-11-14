class Solution {
    static boolean isDistributed(int mid, int[] quantities, int n){
        for(int q: quantities){
            n = n - ((q+mid-1)/mid);
            if(n<0){
                return false;
            }
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int finalAns=0;
        int left=1, right=0;
        
        for(int num: quantities){
            right = Math.max(right, num);
        }
        
        while(left<=right){
            int mid = left + (right-left)/2;
            
            if(isDistributed(mid, quantities, n) == true){
                finalAns = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return finalAns;
        
    }
}