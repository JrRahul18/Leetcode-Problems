class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //Floyd Warshall
        int finalAns=-1;
        int[][] graph = new int[n][n];
        for(int i=0; i<graph.length; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i]=0;
        }
        for(int[] edge: edges){
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        
        for(int edge=0; edge<n; edge++){
            for(int i=0; i<graph.length; i++){
                for(int j=0; j<graph[0].length; j++){
                    int dist = graph[i][edge] + graph[edge][j];
                    if(dist > 0){
                        graph[i][j] = Math.min(graph[i][j], dist);
                    }
                }
            }
        }
        
        int minCities=n;
        
        for(int i=0; i<graph[0].length; i++){
            int count=0;
            for(int j=0; j<graph[0].length; j++){
                if(graph[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=minCities){
                minCities = count;
                finalAns = i;
            }
        }
        return finalAns;
        
        
    }
}