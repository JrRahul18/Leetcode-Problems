class Solution {
    public int passThePillow(int n, int time) {
        int div = time/(n-1);
        int rem = time%(n-1);
        if(div%2 == 0){
            return rem+1;
        }
        return n-rem;
    }
}