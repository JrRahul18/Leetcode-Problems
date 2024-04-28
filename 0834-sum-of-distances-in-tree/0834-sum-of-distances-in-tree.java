class Solution {
    long rootDistance=0;
    public int dfsRoot(int current, int parent, int currentDepth, HashMap<Integer, List<Integer>> graph, int[]countDistance){
        int totalCount = 1;
        rootDistance+=currentDepth;
        
        for(int nbr: graph.get(current)){
            if(nbr == parent) continue;
            
            totalCount +=dfsRoot(nbr, current, currentDepth+1, graph, countDistance);
        }
        countDistance[current] = totalCount;
        return totalCount;
    }
    public void dfs(int parent, int previousNode, HashMap<Integer, List<Integer>> graph, int[]countDistance, int[]finalAns){
        for(int nbr: graph.get(parent)){
            if(nbr == previousNode) continue;
            
            finalAns[nbr] = finalAns[parent]-countDistance[nbr] + (graph.size() - countDistance[nbr]);
            
            dfs(nbr, parent, graph, countDistance, finalAns);
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] finalAns = new int[n];
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[]edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int[] countDistance = new int[n];
        
        dfsRoot(0, -1, 0, graph, countDistance);
        finalAns[0] = (int)rootDistance;
        
        dfs(0, -1, graph, countDistance, finalAns);
        return finalAns;
    }
}