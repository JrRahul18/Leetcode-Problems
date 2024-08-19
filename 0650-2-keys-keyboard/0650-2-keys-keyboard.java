class Solution {
    public int minSteps(int n) {
        int finalAns = 0;
        int div = 2;
        while(n>1){
            while(n%div == 0){
                finalAns +=div;
                n = n/div;
            }
            div++;
        }
        return finalAns;
    }
}