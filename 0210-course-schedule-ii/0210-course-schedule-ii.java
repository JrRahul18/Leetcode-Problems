class Solution {
    public int[] BFSTraversal(HashMap<Integer, List<Integer>> graph, int[] inDegree ){
        int[] finalAns =new int[inDegree.length];
        Queue<Integer> q = new LinkedList<>();
        int count =0;
        int pointer=0;
        
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
                if(inDegree[nbr] ==0){
                    q.add(nbr);
                    
                }
            }
            finalAns[pointer] = u;
            pointer++;
            count++;
        }
        if(count != inDegree.length){
            return new int[]{};
        }
        return finalAns;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            graph.put(i, new ArrayList<Integer>());
        }
        for(int[] course: prerequisites){
            graph.get(course[1]).add(course[0]);
            inDegree[course[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        return BFSTraversal(graph, inDegree);
        
    }
}