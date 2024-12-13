class Solution {
    class Pair{
        int val;
        int idx;
        Pair(int val, int idx){
            this.val=val;
            this.idx=idx;
        }
    }
    public long findScore(int[] nums) {
        long finalAns=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.val==b.val){
                return a.idx-b.idx;
            }
            else{
                return a.val-b.val;
            }
        });
        HashSet<Integer> hset = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            pq.add(new Pair(nums[i], i));
        }
        
        while(!pq.isEmpty()){
            Pair temp = pq.peek();
            pq.poll();
            if(!hset.contains(temp.idx)){
                finalAns+=temp.val;
                hset.add(temp.idx);
                hset.add(temp.idx-1);
                hset.add(temp.idx+1);
            }
        }
        
        return finalAns;
    }
}