class Solution {
    public boolean DFSTraversal(int u, int currentSet, HashMap<Integer, List<Integer>> hmap, int []checkVisited){
        checkVisited[u] = currentSet;
        for(int nbr: hmap.get(u)){
            if(checkVisited[nbr] == currentSet) return false;
            if(checkVisited[nbr] == -1){
                int nextSet = 1-currentSet;
                if(DFSTraversal(nbr, nextSet, hmap, checkVisited)==false) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        for(int i=0; i<n; i++){
            hmap.put(i, new ArrayList<Integer>());
        }
        for(int i=0; i<graph.length; i++){
            // for(int j=0; j<graph[i].length; j++){
            //     graph.get(i).add(graph[i][j]);
            // }
            for(int u: graph[i]){
                hmap.get(i).add(u);
            }
        }
        int[] checkVisited = new int[n];
        Arrays.fill(checkVisited, -1);
        
        for(int i=0; i<n; i++){
            if(checkVisited[i] == -1 && DFSTraversal(i, 1, hmap, checkVisited) == false){
                return false;
            }
        }
        return true;
        
        
    }
}