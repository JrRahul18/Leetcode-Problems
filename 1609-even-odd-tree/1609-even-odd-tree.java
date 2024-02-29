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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int prevVal = -1;
            if(level%2 == 0){
                prevVal = Integer.MIN_VALUE;
            }
            else{
                prevVal = Integer.MAX_VALUE;
            }
            for(int i=0; i<size; i++){

                if(level%2 == 0){
                    TreeNode temp = q.peek();
                    q.poll();
                    if(temp.val%2 == 0 || temp.val <= prevVal){
                        return false;
                    }
                    if(temp.left != null){
                        q.add(temp.left);
                    }
                    if(temp.right != null){
                        q.add(temp.right);
                    }
                    prevVal = temp.val;
                }
                else if(level%2 != 0){
                    TreeNode temp = q.peek();
                    q.poll();
                    if(temp.val%2 != 0 || temp.val >= prevVal){
                        return false;
                    }
                    if(temp.left != null){
                        q.add(temp.left);
                    }
                    if(temp.right != null){
                        q.add(temp.right);
                    }
                    prevVal = temp.val;
                }
            }
            level++;
        }
        return true;
    }
}