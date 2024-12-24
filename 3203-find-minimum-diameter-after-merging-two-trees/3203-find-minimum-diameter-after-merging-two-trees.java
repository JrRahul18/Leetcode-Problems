class Solution {
    
    public List<Integer> bfs(HashMap<Integer, List<Integer>> tree, int src){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        HashSet<Integer> checkVisited = new HashSet<>();
        checkVisited.add(src);
        
        int maxDistance=0, farthestNode=0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0; i<size; i++){
                int temp = q.peek();
                q.poll();
                
                farthestNode = temp;
                for(int nbr: tree.getOrDefault(temp, new ArrayList<>())){
                    
                    if(!checkVisited.contains(nbr)){
                        checkVisited.add(nbr);
                        q.add(nbr);
                    }
                }
            }
            if(!q.isEmpty()){
                maxDistance++;
            }
            
        }
        return Arrays.asList(farthestNode, maxDistance);
        
        
    }
    
    public int getDiameter(HashMap<Integer, List<Integer>> tree){
        
        List<Integer> maxNode = bfs(tree, 0);
        
        List<Integer> diameterLst = bfs(tree, maxNode.get(0));
        
        return diameterLst.get(1);
    }
    
    public HashMap<Integer, List<Integer>> makeGraph(int[][] edges){
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int[] edge: edges){
            
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new ArrayList<>());
            }
            
            if(!graph.containsKey(edge[1])){
                graph.put(edge[1], new ArrayList<>());
            }
            
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        HashMap<Integer, List<Integer>> tree1 = makeGraph(edges1);
        HashMap<Integer, List<Integer>> tree2 = makeGraph(edges2);
        
        int d1 = getDiameter(tree1);
        int d2 = getDiameter(tree2);
        
        int total = (d1+1)/2 + (d2+1)/2 + 1;
        
        return Math.max(d1, Math.max(d2, total));
    }
}