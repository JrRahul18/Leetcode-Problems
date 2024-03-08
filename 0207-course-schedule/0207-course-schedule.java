class Solution {
    public static boolean DFSTraversal(int u, HashMap<Integer, List<Integer>> graph, boolean[]checkVisited, boolean[]recursionVisited){
        checkVisited[u] = true;
        recursionVisited[u] = true;
        for(int nbr: graph.get(u)){
            if(checkVisited[nbr] == true && recursionVisited[nbr] == true){
                return false;
            }
            if(checkVisited[nbr] == false && DFSTraversal(nbr, graph, checkVisited, recursionVisited) == false){
                return false;
            }
        }
        recursionVisited[u] = false;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            graph.put(i, new ArrayList<Integer>());
        }
        for(int []course: prerequisites){
            graph.get(course[1]).add(course[0]);
        }
        boolean[]checkVisited = new boolean[numCourses];
        boolean[]recursionVisited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(checkVisited[i] == false && DFSTraversal(i, graph, checkVisited, recursionVisited) == false){
                return false;
            }
        }
        return true;
    }
}