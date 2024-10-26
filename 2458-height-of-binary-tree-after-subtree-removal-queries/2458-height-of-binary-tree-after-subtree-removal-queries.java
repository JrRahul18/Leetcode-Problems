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
    static int[] leftMax;
    static int[] rightMax;
    static int[] removal;
    public int[] treeQueries(TreeNode root, int[] queries) {
        leftMax = new int[100001];
        rightMax = new int[100001];
        removal = new int[100001];
        fillMax(root, 0);
        removeDepth(root, 0);
        
        for(int i=0; i<queries.length; i++){
            queries[i] = removal[queries[i]];
        }
        return queries;

    }
    public int fillMax(TreeNode root, int level){
        
        if(root == null)return level-1;
        
        int lm=fillMax(root.left, level+1);
        int rm=fillMax(root.right, level+1);
        
        leftMax[root.val] = lm;
        rightMax[root.val] = rm;
        
        return Math.max(lm, rm);
    }
    
    public void removeDepth(TreeNode root, int level){
        if(root == null) return;
        
        
        removal[root.val] = level;
        
        removeDepth(root.left, Math.max(rightMax[root.val], level));
        removeDepth(root.right, Math.max(leftMax[root.val], level));
    }
}