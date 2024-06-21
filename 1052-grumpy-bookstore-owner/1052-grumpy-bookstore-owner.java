class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int finalAns = 0;
        for(int i=0; i<grumpy.length; i++){
            if(grumpy[i] == 0){
                finalAns+=customers[i];
            }
        }
        
        int current=0;
        int max = 0;
        for(int i=0; i<minutes; i++){
            if(grumpy[i] == 1){
                current+=customers[i];
            }
        }
        max = current;
        int i=0, j=minutes;
        while(j<customers.length){
            if(grumpy[j] == 1){
                current+=customers[j];
            }
            if(grumpy[i] == 1){
                current-=customers[i];
            }
            max = Math.max(max, current);
            i++;
            j++;
        }
        return finalAns+max;
    }
}