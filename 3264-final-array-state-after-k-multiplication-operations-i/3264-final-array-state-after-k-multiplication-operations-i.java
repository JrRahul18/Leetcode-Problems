class Solution {
    class Pair{
        int num;
        int idx;
        Pair(int num, int idx){
            this.num=num;
            this.idx=idx;
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int[] finalAns = new int[nums.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.num==b.num ? a.idx-b.idx : a.num-b.num);
        
        for(int i=0; i<nums.length; i++){
            pq.add(new Pair(nums[i], i));
        }
        
        while(k>0){
            Pair temp = pq.peek();
            pq.poll();
            pq.add(new Pair(temp.num * multiplier, temp.idx));
            k--;
        }
        
        while(!pq.isEmpty()){
            Pair temp = pq.peek();
            pq.poll();
            finalAns[temp.idx]=temp.num;
        }
        return finalAns;
    }
}