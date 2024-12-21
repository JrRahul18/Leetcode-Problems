class Solution {
    static int finalAns=0;
    static long dfs(int node, HashMap<Integer, List<Integer>> tree, boolean[] checkVisited, int[] values, int k){
        checkVisited[node]=true;
        
        long store=values[node];
        for(int nbr: tree.get(node)){
            if(checkVisited[nbr]==false){
                store+=dfs(nbr, tree, checkVisited, values, k);
            }
        }
        if(store%k == 0){
            finalAns++;
            return 0;
        }
        return store;
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        finalAns=0;
        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        
        for(int i=0; i<n; i++){
            tree.put(i, new ArrayList<>());
        }
        
        for(int[] edge: edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        boolean[] checkVisited = new boolean[n];
        
        long ans = dfs(0, tree, checkVisited, values, k);
        return finalAns;
    }
}