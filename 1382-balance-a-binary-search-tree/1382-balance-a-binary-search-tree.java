/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static List <Integer> nodes;
    public void traverse(TreeNode root){
        if(root == null) return;
        
        traverse(root.left);
        nodes.add(root.val);
        traverse(root.right);
        
    }
    public TreeNode solve(int left, int right, TreeNode root){
        if(left > right) return null;
        
        int mid = left + (right-left)/2;
        
        TreeNode temp = new TreeNode(nodes.get(mid));
        
        temp.left = solve(left, mid-1, root);
        temp.right = solve(mid+1, right, root);
        
        return temp;
    }
    public TreeNode balanceBST(TreeNode root) {
        nodes = new ArrayList<>();
        traverse(root);
        
        return solve(0, nodes.size()-1, root);
    }
}