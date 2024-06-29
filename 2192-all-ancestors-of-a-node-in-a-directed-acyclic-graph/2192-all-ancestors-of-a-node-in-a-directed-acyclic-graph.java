class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> finalAns = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n];
        
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
            finalAns.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int u = q.peek();
            q.poll();
            for(int nbr: graph.get(u)){
                inDegree[nbr]--;
                finalAns.get(nbr).add(u);
                for(int temp: finalAns.get(u)){
                    if(!finalAns.get(nbr).contains(temp)){
                        finalAns.get(nbr).add(temp);
                    }
                }
                if(inDegree[nbr] == 0){
                    q.add(nbr);
                }
            }
            
        }
        for(List<Integer> arl: finalAns){
            Collections.sort(arl);
        }
        System.out.println(finalAns);
        return finalAns;
        
    }
}