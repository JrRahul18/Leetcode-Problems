class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int dfs(HashMap<Integer, List<Pair>> graph, int n){
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b)-> a.weight-b.weight );
        pq.add(new Pair(0, 0));
        
        while(!pq.isEmpty()){
            Pair temp = pq.peek();
            pq.poll();
            
            for(Pair nbr: graph.get(temp.node)){
                if(temp.weight + nbr.weight < result[nbr.node]){
                    result[nbr.node] = temp.weight+nbr.weight;
                    pq.add(new Pair(nbr.node, result[nbr.node]));
                }
            }
        }
        return result[n-1];
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] finalAns = new int[queries.length];
        
        HashMap<Integer, List<Pair>> graph = new HashMap<>();
        
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int i=0; i<n-1; i++){
            graph.get(i).add(new Pair(i+1, 1));
        }
        
        int p=0;
        for(int[] q: queries){
            graph.get(q[0]).add(new Pair(q[1], 1));
            finalAns[p]=dfs(graph, n);
            p++;
        }
        
        return finalAns;
    }
}