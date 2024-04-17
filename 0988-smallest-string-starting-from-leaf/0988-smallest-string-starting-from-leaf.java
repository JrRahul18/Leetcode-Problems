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
    String finalAns="";
    
    public void dfs(TreeNode root, String temp){
        if(root == null) return;
        char ch = (char)(root.val + 'a');
        temp = ch+temp;
        if (root.left == null && root.right == null){
            if(finalAns == "" || finalAns.compareTo(temp) > 0){
                finalAns = temp;
            }
            return;
        }
        dfs(root.left, temp);
        dfs(root.right, temp);
        
    }
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return finalAns;
    }
}