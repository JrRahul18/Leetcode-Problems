class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        PriorityQueue<Integer> endIntervals = new PriorityQueue<>();
        
        for(int[] interval: intervals){
            if(!endIntervals.isEmpty() && endIntervals.peek() < interval[0] ){
                endIntervals.poll();
            }
            endIntervals.offer(interval[1]);
        }
        return endIntervals.size();
    }
}