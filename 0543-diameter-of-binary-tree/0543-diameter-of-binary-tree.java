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
    public int Traverse(TreeNode root){
        if(root == null) return 0;

        int left = Traverse(root.left);
        int right = Traverse(root.right);

        finalAns = Math.max(finalAns, left+right);

        return Math.max(left, right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        finalAns = Integer.MIN_VALUE;
        Traverse(root);
        return finalAns;

    }
}