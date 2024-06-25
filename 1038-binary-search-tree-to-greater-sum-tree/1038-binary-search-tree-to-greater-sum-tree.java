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
    static int finalAns;
    public void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.right);
        finalAns += root.val;
        root.val = finalAns;
        traverse(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        finalAns = 0;
        traverse(root);
        return root;
        
    }
}