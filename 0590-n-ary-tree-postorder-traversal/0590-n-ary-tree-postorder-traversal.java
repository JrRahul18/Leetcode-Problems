/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    static List<Integer> finalAns;
    static void dfs(Node root){
        if(root == null) return;
        
        for(Node child: root.children){
            dfs(child);
        }
        finalAns.add(root.val);
    }
    
    public List<Integer> postorder(Node root) {
        finalAns = new ArrayList<>();
        dfs(root);
        return finalAns;
        
    }
}