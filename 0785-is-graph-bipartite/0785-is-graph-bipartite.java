class Solution {
    public static boolean BFSTraversal(int u, int currentSet, HashMap<Integer, List<Integer>> hmap, int[] checkVisited){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        checkVisited[u] = currentSet;
        while(!q.isEmpty()){
            int temp = q.peek();
            q.poll();
            for(int nbr: hmap.get(temp)){
                if(checkVisited[nbr] == checkVisited[temp]) return false;
                if(checkVisited[nbr] == -1){
                    checkVisited[nbr] = 1 - checkVisited[temp];
                    q.add(nbr);
                }
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
            for(int u: graph[i]){
                hmap.get(i).add(u);
            }
        }
        int[] checkVisited = new int[n];
        Arrays.fill(checkVisited, -1);
        
        for(int i=0; i<n; i++){
            if(checkVisited[i] == -1 && BFSTraversal(i, 1, hmap, checkVisited) == false){
                return false;
            }
        }
        return true;
        
        
    }
}