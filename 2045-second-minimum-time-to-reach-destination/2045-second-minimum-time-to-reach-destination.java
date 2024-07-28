class Solution {
    class Pair{
        int node;
        int visit;
        Pair(int node, int visit){
            this.node = node;
            this.visit = visit;
        }
    }
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int []edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] d1 = new int[n+1];
        int[] d2 = new int[n+1];
        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 1));
        d1[1]=0;
        
        
        while(!q.isEmpty()){
            Pair temp = q.peek();
            q.poll();
            
            int timeTaken = d1[temp.node]; 
            if(temp.visit >1){
                timeTaken = d2[temp.node];
            }
            
            if(temp.node == n && d2[n] != Integer.MAX_VALUE) return d2[n];
            
            int div = timeTaken/change;
            if(div % 2 == 1){
                timeTaken = change * (div+1);
            }
            
            for(int nbr: graph.get(temp.node)){
                if(d1[nbr] == Integer.MAX_VALUE){
                    d1[nbr] = timeTaken + time;
                    q.add(new Pair(nbr, 1));
                }else if(d2[nbr] == Integer.MAX_VALUE && d1[nbr] != timeTaken + time){
                    d2[nbr] = timeTaken+ time;
                    q.add(new Pair(nbr, 2));
                }
            }
        }
        return -1;
    }
}