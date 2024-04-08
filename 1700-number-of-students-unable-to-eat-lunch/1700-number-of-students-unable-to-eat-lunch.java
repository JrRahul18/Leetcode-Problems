class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int student0 = 0;
        int student1 = 0;
        for(int i=0; i<students.length; i++){
            if(students[i] == 0) student0++;
            else student1++;
        }
        for(int i=0; i < sandwiches.length; i++){
            if(sandwiches[i]==0 && student0 == 0) return sandwiches.length-i; 
            else if(sandwiches[i]==1 && student1 == 0) return sandwiches.length-i;
            if(sandwiches[i]==0) student0--;
            else if(sandwiches[i]==1) student1--;
        }
        return 0;
    }
}