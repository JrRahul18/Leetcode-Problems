class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Pair>> graph = new HashMap<>();
        for(int i=0; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge: times){
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0]=-1;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.weight-b.weight);
        pq.add(new Pair(k, 0));
        distance[k] = 0;
        
        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i=0; i<size; i++){
                Pair temp = pq.peek();
                pq.poll();
                int currentNode = temp.node;
                int currentWeight = temp.weight;
                for(Pair nbr: graph.get(currentNode)){
                    if(nbr.weight + currentWeight < distance[nbr.node]){
                        distance[nbr.node] = nbr.weight+currentWeight;
                        pq.add(new Pair(nbr.node, nbr.weight+currentWeight));
                    }
                }
            }
        }
        int finalAns = Integer.MIN_VALUE;
        for(int i=1; i<distance.length; i++){
            finalAns = Math.max(finalAns, distance[i]);
        }
        if(finalAns == Integer.MAX_VALUE) return -1;
        return finalAns;
        
    }
}