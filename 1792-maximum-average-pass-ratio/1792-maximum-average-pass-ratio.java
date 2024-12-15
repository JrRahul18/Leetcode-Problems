class Solution {
    class Tuple{
        double passed;
        double total;
        double passDiff;
        
        Tuple(double passed, double total, double passDiff){
            this.passed = passed;
            this.total = total;
            this.passDiff = passDiff;
        }
        
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double finalAns=0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>( (a, b) -> Double.compare(b.passDiff, a.passDiff) );
        
        for(int[] c: classes){
            double c0 = (double)c[0];
            double c1 = (double)c[1];
            double newPassRatio = ((c0+1)/(c1+1)) - (c0/c1);
            
            pq.add(new Tuple((double) c[0], (double) c[1], newPassRatio));
        }
        
        while(extraStudents > 0){
            Tuple temp = pq.peek();
            pq.poll();
            
            temp.passed+=1;
            temp.total+=1;
            
            double currentPassed = (double) (temp.passed/temp.total);
            double newPassed = (double) ((temp.passed+1)/(temp.total+1));
            
            double newPassRatio  = newPassed-currentPassed;
            
            pq.add(new Tuple(temp.passed, temp.total, newPassRatio));
            extraStudents--;
        }
        
        while(!pq.isEmpty()){
            Tuple temp = pq.peek();
            pq.poll();
            finalAns += temp.passed/temp.total;
        }
        return finalAns/classes.length;
        
    }
}