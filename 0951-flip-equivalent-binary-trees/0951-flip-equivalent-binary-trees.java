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
    boolean check(TreeNode node1, TreeNode node2){
        if(node1==null && node2 == null) return true;
        
        if(node1 == null || node2 == null || node1.val != node2.val) return false;
        
        boolean ans1 = check(node1.left, node2.left) && check(node1.right, node2.right);
        boolean ans2 = check(node1.left, node2.right) && check(node1.right, node2.left);
        return ans1 || ans2;
        
        
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return check(root1, root2);
    }
}