class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int finalAns=Integer.MAX_VALUE;
        
        long[] prefixSum= new long[nums.length];
        prefixSum[0]=nums[0];
        
        for(int i=1; i<nums.length; i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
          
        Deque<Integer> deq = new LinkedList<>();
        int j=0;
        
        while(j<nums.length){
            if(prefixSum[j]>=k){
                finalAns = Math.min(finalAns, j+1);
            }
            while(!deq.isEmpty() && prefixSum[j]-prefixSum[deq.peekFirst()]>=k){
                int temp = deq.peekFirst();
                deq.pollFirst();
                finalAns = Math.min(finalAns, j-temp);
            }
            
            while(!deq.isEmpty() && prefixSum[j]<=prefixSum[deq.peekLast()]){
                deq.pollLast();
            }
            deq.addLast(j);
            j++;
        }
        return finalAns ==Integer.MAX_VALUE ? -1 : finalAns;
    }
}
