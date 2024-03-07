class Solution {
    public void DFSTraversal(int u, HashMap<Integer, List<Integer>> graph, boolean [] checkVisited){
        checkVisited[u] = true;
        for(int nbr: graph.get(u)){
            if(checkVisited[nbr] == false){
                DFSTraversal(nbr, graph, checkVisited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        HashMap<Integer, List<Integer>>graph = new HashMap<>();
        for(int i=0; i<v; i++){
            graph.put(i, new ArrayList<Integer>());
        }
        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        int finalAns = 0;
        boolean[] checkVisited = new boolean[v];

        for(int i=0; i<v; i++){
            if(checkVisited[i] == false){
                DFSTraversal(i,graph, checkVisited);
                finalAns++;
            }
        }
        return finalAns;

    }
}