class Solution {
    public static int find(int i, int[] parent){
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }
    public static void union(int i ,int j, int[]parent, int[]rank){
        int parent_i = find(i, parent);
        int parent_j = find(j, parent);
        if(rank[parent_i] > rank[parent_j]){
            parent[parent_j] = parent_i;
        }
        else if(rank[parent_j] > rank[parent_i]){
            parent[parent_i] = parent_j; 
        }
        else{
            parent[parent_i] = parent_j;
            rank[parent_j]++;
        }
    }
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] rank = new int[26];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        
        for(String eqn: equations){
            int x = eqn.charAt(0)-'a';
            int y = eqn.charAt(3)-'a';
            System.out.println(x +", "+y );
            if(eqn.charAt(1) == '='){
                union(x, y, parent, rank);
            }
        }
        
        for(String eqn: equations){
            int x = eqn.charAt(0)-'a';
            int y = eqn.charAt(3)-'a';
            if(eqn.charAt(1) == '!'){
                int parent_x = find(x, parent);
                int parent_y = find(y, parent);
                if(parent_x == parent_y) return false;
            }
        }
        return true;
    }
}