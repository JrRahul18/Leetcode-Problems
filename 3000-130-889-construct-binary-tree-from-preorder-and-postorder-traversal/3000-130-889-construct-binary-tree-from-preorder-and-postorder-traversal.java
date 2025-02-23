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
    static TreeNode traverse(int preStart, int preEnd, int postStart, int[] preorder, int[] postorder){

        if(preStart > preEnd){
            return null;
        }

        int nodeVal = preorder[preStart];
        TreeNode root = new TreeNode(nodeVal);

        if(preStart == preEnd){
            return root;
        }

        int leftVal = preorder[preStart+1];
        
        int j = postStart;

        while(postorder[j] != leftVal){
            j++;
        }
        int countNodes = j - postStart + 1;

        root.left = traverse(preStart+1, preStart+countNodes, postStart, preorder, postorder);

        root.right = traverse(preStart+countNodes+1, preEnd,  j+1, preorder, postorder);

        return root;

    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return traverse(0, preorder.length-1, 0, preorder, postorder);
    }
}