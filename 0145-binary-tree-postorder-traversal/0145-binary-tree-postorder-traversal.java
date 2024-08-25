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
    static List<Integer> finalAns;
    public void traverse(TreeNode root){
        if(root == null) return;
        
        traverse(root.left);
        traverse(root.right);
        finalAns.add(root.val);
        
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        finalAns = new ArrayList<Integer>();
        traverse(root);
        return finalAns;
    }
}