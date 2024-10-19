class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0';
        
        int length = (1 << n) - 1;
        int mid = (length/2)+1;
        
        if(k == mid) return '1';
        
        if(k < mid){
            return findKthBit(n-1, k);
        }
        else{
            char ch = findKthBit(n-1, length-k + 1);
            if(ch =='0')return '1';
            return '0';
        }
        // return '0';
    }
}