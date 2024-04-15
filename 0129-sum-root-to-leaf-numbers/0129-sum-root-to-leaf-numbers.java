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
    public int sumNumbers(TreeNode root) {
        int finalAns = 0;
        if(root == null) return finalAns;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode temp = q.poll();
                if(temp.left == null && temp.right == null){
                    finalAns+=temp.val;
                }
                if(temp.left != null){
                    temp.left.val = (temp.val*10) + temp.left.val;
                    q.add(temp.left);
                }
                if(temp.right != null){
                    temp.right.val = (temp.val*10) + temp.right.val;
                    q.add(temp.right);
                }
            }
        }
        return finalAns;
    }
}