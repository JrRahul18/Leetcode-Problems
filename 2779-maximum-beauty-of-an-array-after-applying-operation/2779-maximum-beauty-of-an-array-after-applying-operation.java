class Solution {
    class Pair{
        int start;
        int end;
        Pair(int start, int end){
            this.start=start;
            this.end=end;
        }
    }
    public int maximumBeauty(int[] nums, int k) {
        int finalAns=0;
        List<Pair> lst = new ArrayList<>();
        for(int num: nums){
            lst.add(new Pair(num-k, num+k));
        }
        Collections.sort(lst, (a, b) -> a.start-b.start);
        
        Queue<Pair> q = new LinkedList<>();
        
        for(Pair temp: lst){
            while(!q.isEmpty() && q.peek().end < temp.start){
                q.poll();
            }
            q.add(temp);
            finalAns = Math.max(finalAns, q.size());
        }
        return finalAns;
    }
}