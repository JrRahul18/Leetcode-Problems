class Solution {
public:
    vector<int> parent;
    vector<int> rank;
    int find(int i){
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent[i]);
    }
    void Union(int i, int j){
        int parent_i = find(i);
        int parent_j = find(j);
        if(parent_i == parent_j) return;
        
        if(rank[parent_i]> rank[parent_j]){
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
    int makeConnected(int n, vector<vector<int>>& connections) {
        if(connections.size() < n-1){
            return -1;
        }
        // vector<int> parent;
        // vector<int> rank;
        parent.resize(n);
        rank.resize(n, 0);
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        int computers = n;
        
        for(vector<int> connection: connections){
            if(find(connection[0]) != find(connection[1])){
                Union(connection[0], connection[1]);
                computers--;
            }
        }
        return computers-1;
        
        
        
    }
};