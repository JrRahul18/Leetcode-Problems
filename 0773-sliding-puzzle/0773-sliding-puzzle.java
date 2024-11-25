class Solution {
    public int slidingPuzzle(int[][] board) {
        int finalAns = 0;
        String str = "";
        String target = "123450";
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                str+=board[i][j];
            }
        }
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, new ArrayList<>( Arrays.asList(1, 3) ));
        graph.put(1, new ArrayList<>( Arrays.asList(0, 2, 4) ));
        graph.put(2, new ArrayList<>( Arrays.asList(1, 5) ));
        graph.put(3, new ArrayList<>( Arrays.asList(0, 4) ));
        graph.put(4, new ArrayList<>( Arrays.asList(3, 1, 5) ));
        graph.put(5, new ArrayList<>( Arrays.asList(2, 4) ));
        
        Queue<String> q = new LinkedList<>();
        
        HashSet<String> checkVisited = new HashSet<>();
        checkVisited.add(str);
        q.add(str);
        
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                String temp = q.peek();
                q.poll();
                
                if(temp.equals(target)) return finalAns;
                
                int idx = temp.indexOf('0');
                
                for(int nbr: graph.get(idx)){
                    
                    char[] tempArray = temp.toCharArray();
                    
                    char t = tempArray[idx];
                    tempArray[idx]=tempArray[nbr];
                    tempArray[nbr]=t;
                    
                    String newStr = new String(tempArray);
                    
                    if(!checkVisited.contains(newStr)){
                        checkVisited.add(newStr);
                        q.add(newStr);
                    }
                }
            }
            finalAns++;
        }
        return -1;

    }
}