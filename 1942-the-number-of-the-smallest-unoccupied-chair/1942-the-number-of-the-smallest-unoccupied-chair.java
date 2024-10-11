class Solution {
    class Tuple{
        int time;
        int idx;
        int isArrived;
        Tuple(int time, int idx, int isArrived){
            this.time = time;
            this.idx = idx;
            this.isArrived = isArrived;
        }
    }
    public int smallestChair(int[][] times, int targetFriend) {
        int[] getChair = new int[times.length];
        Arrays.fill(getChair, -1);
        
        
        List<Tuple> timings = new ArrayList<>();
        
        for(int i=0; i<times.length; i++){
            timings.add(new Tuple(times[i][0], i, 1 ));
            timings.add(new Tuple(times[i][1], i, 0 ));
        }
        
        Collections.sort(timings, (a, b) -> a.time == b.time ? Integer.compare(a.isArrived, b.isArrived) : Integer.compare(a.time, b.time));
        
        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        
        for(int i=0; i<times.length; i++){
            chairs.offer(i);
        }
        
        for(Tuple timing: timings){
            
            if(timing.isArrived == 1){
                int chair = chairs.peek();
                chairs.poll();
                getChair[timing.idx] = chair;
                
                // if(timing.idx == targetFriend) return chair;
            }
            else{
                chairs.offer(getChair[timing.idx]);
            }
        }
        return getChair[targetFriend];
        
    }
}