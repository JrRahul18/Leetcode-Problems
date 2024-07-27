class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long finalAns=0;
        long[][] graph = new long[26][26];
        
        for(int i=0; i<graph.length; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i]=0;
        }
        
        for(int i=0; i<original.length; i++){
            int originalChar = original[i]-'a';
            int changedChar = changed[i]-'a';
            graph[originalChar][changedChar] = Math.min(graph[originalChar][changedChar],  cost[i]);
        }
        
        for(int ch=0; ch<26; ch++){
            for(int i=0; i<graph.length; i++){
                for(int j=0; j<graph[0].length; j++){
                    long dist = graph[i][ch] + graph[ch][j];
                    if(dist>=0){
                        graph[i][j] = Math.min(graph[i][j], dist);
                    }
                }
            }
        }
        for(int i=0; i<source.length(); i++){
            int node = source.charAt(i)-'a';
            int dest = target.charAt(i)-'a';
            if(graph[node][dest] == Integer.MAX_VALUE){
                return -1;
            }
            finalAns +=graph[node][dest];
        }
        return finalAns;
        
    }
}