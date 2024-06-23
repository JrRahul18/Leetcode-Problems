class Solution {
    class Pair{
        int idx;
        int val;
        Pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public int longestSubarray(int[] nums, int limit) {
        int finalAns=0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.val != b.val ? a.val - b.val : a.idx-b.idx);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) ->  a.val != b.val ? b.val - a.val : a.idx-b.idx);
        
        int i=0, j=0;
        
        while(j<nums.length){
            maxHeap.add(new Pair(j, nums[j]));
            minHeap.add(new Pair(j, nums[j]));
            
            while(maxHeap.peek().val - minHeap.peek().val > limit){
                i = Math.min(maxHeap.peek().idx, minHeap.peek().idx) + 1;
                
                while(maxHeap.peek().idx < i){
                    maxHeap.poll();
                }
                while(minHeap.peek().idx < i){
                    minHeap.poll();
                }
            }
            finalAns = Math.max(finalAns, j-i+1);
            j++;
        }
        return finalAns;
        
    }
}