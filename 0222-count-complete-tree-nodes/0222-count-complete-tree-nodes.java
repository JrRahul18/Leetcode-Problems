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
    public int getLeftHeight(TreeNode root){
        TreeNode temp = root;
        int leftHeight = 0;
        while(temp!= null){
            temp = temp.left;
            leftHeight++;
        }
        return leftHeight;
    }
    public int getRightHeight(TreeNode root){
        TreeNode temp = root;
        int rightHeight = 0;
        while(temp!= null){
            temp = temp.right;
            rightHeight++;
        }
        return rightHeight;
    }
    public int countNodes(TreeNode root) {
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if(leftHeight == rightHeight){
            return (int)(Math.pow(2, leftHeight)-1);
        }
        return countNodes(root.left)+ countNodes(root.right)+1;
    }
}