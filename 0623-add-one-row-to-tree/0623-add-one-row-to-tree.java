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
    public TreeNode traverse(TreeNode root, int val, int depth, int count){
        if(root == null) return null;
        if(count == depth-1){
            TreeNode tempLeft = root.left;
            TreeNode tempRight = root.right;
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = tempLeft;
            root.right.right = tempRight;
            return root;
        }
        root.left = traverse(root.left, val, depth, count+1);
        root.right = traverse(root.right, val, depth, count+1);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        return traverse(root, val, depth, 1);
    }
}