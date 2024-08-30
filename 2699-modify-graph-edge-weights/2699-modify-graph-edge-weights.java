class Solution {
    class Pair{
        int node;
        long weight;
        Pair(int node, long weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public long dijkstra(int n, int[][] edges, int source, int destination){
        HashMap<Integer, List<Pair>> graph = new HashMap<>();
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<Pair>());
        }
        
        for(int edge[]: edges){
            if(edge[2] != -1){
                graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
                graph.get(edge[1]).add(new Pair(edge[0], edge[2]));

            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare (a.weight, b.weight));
        
        boolean[] checkVisited = new boolean[n];
        long[] dest = new long[n];
        Arrays.fill(checkVisited, false);
        Arrays.fill(dest, Long.MAX_VALUE);
        dest[source] = 0;
        pq.add(new Pair(source, 0));
        
        while(!pq.isEmpty()){
            Pair temp = pq.peek();
            pq.poll();
            
            if(checkVisited[temp.node] == true) continue;
            
            checkVisited[temp.node] = true;
            
            for(Pair nbr: graph.get(temp.node)){
                if(dest[nbr.node] > temp.weight + nbr.weight ){
                    dest[nbr.node] = temp.weight + nbr.weight;
                    pq.add(new Pair(nbr.node, dest[nbr.node]));
                }
            }
        }
        return dest[destination];
    }
    
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        
        
        long shortestPath = dijkstra(n, edges, source, destination);
        
        if(shortestPath < target){
            return new int[0][];
        }
        
        boolean check = (shortestPath == target);
        
        // if(check == true){
        //     for(int edge[]: edges){
        //         if(edge[2] == -1){
        //             edge[2] = Integer.MAX_VALUE;
        //         }
        //     }
        //     return edges;
        // }
        
        for(int edge[]: edges){
            if(edge[2] == -1){
                // if(check == true){
                //     edge[2] = Integer.MAX_VALUE;
                // }
                // else{
                //     edge[2] = 1;
                // }
                
                edge[2] = check ? (int)2e9 : 1;
                
                if(check == false){
                    long temp = dijkstra(n, edges, source, destination);
                    if(temp <= target){
                        check = true;
                        edge[2] += (target - temp);
                    }
                }
            }
        }
        if(check == false){
            return new int[0][];
        }
        
        return edges;
        
        
    }
}