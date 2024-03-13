class Solution {
    public int pivotInteger(int n) {
        int left = 0;
        int right = 0;
        for(int i=1;i <=n; i++){
            left = (i*(i+1))/2;
            right = (n*(n+1))/2 - (i*(i-1))/2;
            if(left == right) return i;
        }
        return -1;
        
    }
}