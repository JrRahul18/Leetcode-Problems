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
    static int pointer;
    static TreeNode solve(int depth, String traversal){
        if(pointer >= traversal.length()){
            return null;
        }

        int temp = pointer;

        while(temp < traversal.length() && traversal.charAt(temp) == '-'){
            temp++;
        }
        int dashLen = temp - pointer;

        if(dashLen != depth){
            return null;
        }

        pointer+=dashLen;

        int val = 0;

        while(pointer < traversal.length() && Character.isDigit(traversal.charAt(pointer))){
            val = val * 10 + (traversal.charAt(pointer)-'0');
            pointer++;
        }

        TreeNode root = new TreeNode(val);

        root.left= solve(depth + 1, traversal);
        root.right= solve(depth + 1, traversal);

        return root;
    }


    public TreeNode recoverFromPreorder(String traversal) {
        pointer =  0;

        return solve(0, traversal);
        
    }
}