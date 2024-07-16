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
    static boolean traverse(TreeNode lca, int value, StringBuilder distance){
        if(lca == null) return false;
        
        if(lca.val == value) return true;
        
        distance.append('L');
        if(traverse(lca.left, value, distance)==true){
            return true;
        }
        distance.deleteCharAt(distance.length()-1);
        distance.append('R');
        
        if(traverse(lca.right, value, distance)==true){
            return true;
        }
        distance.deleteCharAt(distance.length()-1);

        return false;
        
    }
    static TreeNode LCA(TreeNode root, int startValue, int destValue){
        if(root == null) return null;

        if(root.val == startValue || root.val == destValue) return root;

        TreeNode leftTree = LCA(root.left, startValue, destValue);
        TreeNode rightTree = LCA(root.right, startValue, destValue);

        if(leftTree != null && rightTree != null) return root;

        if(leftTree == null) return rightTree;
        if(rightTree == null) return leftTree;

        return root;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder finalAns = new StringBuilder();
        TreeNode lca = LCA(root, startValue, destValue);
        
        StringBuilder toStart = new StringBuilder();
        StringBuilder toDest = new StringBuilder();
        
        traverse(lca, startValue, toStart);
        traverse(lca, destValue, toDest);
        
        for(int i=0; i<toStart.length(); i++){
            finalAns.append('U');
        }
        finalAns.append(toDest);
        return finalAns.toString();
    }
}