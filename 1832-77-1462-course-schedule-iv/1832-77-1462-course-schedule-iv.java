class Solution {
    public boolean dfs(int u, int v, HashMap<Integer, List<Integer>> graph, boolean[] checkVisited){
        checkVisited[u]=true;

        if(u == v)return true;

        boolean result = false;

        for(int nbr: graph.get(u)){
            if(!checkVisited[nbr]){
                result = result || dfs(nbr, v, graph, checkVisited);
            }
        }
        return result;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List <Boolean> finalAns = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0; i<numCourses; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i=0; i<queries.length; i++){
            boolean[] checkVisited = new boolean[numCourses];
            finalAns.add(dfs(queries[i][0], queries[i][1], graph, checkVisited));
        }
        return finalAns;

    }
}