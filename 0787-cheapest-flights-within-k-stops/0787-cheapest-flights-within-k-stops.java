class Solution {
    class Pair{
        int dest;
        int price;
        Pair(int dest, int price){
            this.dest = dest;
            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] storeDist = new int[n];
        Arrays.fill(storeDist, Integer.MAX_VALUE);

        HashMap<Integer, List<Pair>> graph = new HashMap<>();
        for(int[] route: flights){
            if(!graph.containsKey(route[0])){
                graph.put(route[0], new ArrayList<Pair>());
            }
            graph.get(route[0]).add(new Pair(route[1], route[2]));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        int pointer = 0;

        while(!q.isEmpty() && pointer <= k){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair p = q.peek();
                q.poll();
                List<Pair> temp = graph.getOrDefault(p.dest, Collections.emptyList());
                for(Pair t: temp){
                    int nbr = t.dest;
                    int price = t.price;
                    if(storeDist[nbr] > price + p.price){
                        storeDist[nbr] = price + p.price;
                        q.add(new Pair(t.dest, p.price + t.price));
                    }
                }
            }
            pointer++;
        }
        if(storeDist[dst] == Integer.MAX_VALUE) return -1;
        return storeDist[dst];
    }
}