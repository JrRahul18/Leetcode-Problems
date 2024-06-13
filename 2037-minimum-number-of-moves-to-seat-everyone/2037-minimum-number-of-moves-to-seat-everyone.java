class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int finalAns=0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for(int i=0; i<seats.length; i++){
            finalAns+=Math.abs(seats[i]-students[i]);
        }
        return finalAns;

    }
}