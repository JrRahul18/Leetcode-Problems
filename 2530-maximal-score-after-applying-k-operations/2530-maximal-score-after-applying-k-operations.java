class Solution {
    public long maxKelements(int[] nums, int k) {
        long finalAns = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b-a);
        for(int num: nums){
            pq.add(num);
        }
        while(k>0){
            int temp = pq.peek();
            pq.poll();
            finalAns+=temp;
            temp = (int) Math.ceil(temp/3.0);
            pq.add(temp);
            k--;
        }
        return finalAns;
    }
}