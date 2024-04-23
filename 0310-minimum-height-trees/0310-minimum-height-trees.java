class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> finalAns = new ArrayList<>();
        if(n == 1){
            finalAns.add(0);
            return finalAns;
        } 
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 1){
                q.add(i);
            }
        }
        while(n>2){
            int size = q.size();
            n = n-size;
            for(int i=0; i<size; i++){
                int edge = q.peek();
                q.poll();
                for(int nbr: graph.get(edge)){
                    inDegree[nbr]--;
                    if(inDegree[nbr] == 1){
                        q.add(nbr);
                    }
                }
            }
        }
        while(!q.isEmpty()){
            finalAns.add(q.peek());
            q.poll();
        }
        return finalAns;
        
    }
}