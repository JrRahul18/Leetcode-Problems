class Solution {
    class Pair{
        int node;
        double prob;
        Pair(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        HashMap<Integer, List<Pair>> graph = new HashMap<>();
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<Pair>());
        }
        for(int i=0; i<edges.length; i++){
            int[] edge = edges[i];
            graph.get(edge[0]).add(new Pair(edge[1], succProb[i]));
            graph.get(edge[1]).add(new Pair(edge[0], succProb[i]));
        }
        double[] minDistance = new double[n];
        Arrays.fill(minDistance, Double.MIN_VALUE);
        minDistance[start_node] = 1.0;
        
        Queue<Pair> pq = new LinkedList<>();
        
        pq.add(new Pair(start_node, 1.0));
        
        while(!pq.isEmpty()){
            Pair temp = pq.peek();
            pq.poll();
            for(Pair nbr: graph.get(temp.node)){
                if(nbr.prob * temp.prob > minDistance[nbr.node]){
                    minDistance[nbr.node] = nbr.prob * temp.prob;
                    pq.add(new Pair(nbr.node, minDistance[nbr.node]));
                }
            }
            
        }
        if(minDistance[end_node] == Double.MIN_VALUE) return 0;
        
        return minDistance[end_node];
    }
}