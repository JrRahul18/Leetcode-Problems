class Solution {
    class Pair{
        int height;
        int idx;
        Pair(int height, int idx){
            this.height=height;
            this.idx=idx;
        }
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] finalAns = new int[queries.length];
        Arrays.fill(finalAns, -1);
        
        HashMap<Integer,List<Pair> > hmap = new HashMap<>();
        for(int i=0; i<heights.length; i++){
            hmap.put(i, new ArrayList<>());
        }
        
        for(int i=0; i<queries.length; i++){
            int a=queries[i][0];
            int b=queries[i][1];
            
            if(a<b && heights[a] < heights[b]){
                finalAns[i]=b;
            }
            else if(a>b && heights[a]>heights[b]){
                finalAns[i]=a;
            }
            else if(a == b){
                finalAns[i]=a;
            }
            else{
                hmap.get(Math.max(a, b)).add(new Pair( Math.max(heights[a], heights[b]), i ));
                // hmap.put(Math.max(a, b), new Pair( Math.max(heights[a], heights[b]), i));
            }

        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a, b) -> a.height==b.height ? a.idx-b.idx : a.height-b.height );
        
        for(int i=0; i<heights.length; i++){
            int ht = heights[i];
            
            while(!pq.isEmpty() && pq.peek().height < ht){
                Pair temp = pq.poll();
                finalAns[temp.idx]=i;
            }
            
            for(Pair temp: hmap.get(i)){
                pq.add(temp);
            }
        }
        return finalAns;
        
    }
}