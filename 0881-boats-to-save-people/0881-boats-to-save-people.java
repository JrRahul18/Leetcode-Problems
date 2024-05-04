class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int finalAns=0;
        int i=0, j = people.length-1;
        while(i<=j){
            if(people[i] + people[j] <= limit){
                i++;
                j--;
                finalAns++;
            }
            else{
                j--;
                finalAns++;
            }
        }
        return finalAns;
    }
}