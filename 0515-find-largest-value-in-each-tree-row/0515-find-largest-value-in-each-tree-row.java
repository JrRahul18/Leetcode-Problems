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
    static Queue<TreeNode> q;
    static List<Integer> finalAns;
    static List<Integer> solve(TreeNode root){
        if(root != null) q.add(root);
        while(!q.isEmpty()){
            int maxVal = Integer.MIN_VALUE;
            int n = q.size();

            for(int i = 0; i<n; i++){
                TreeNode temp = q.poll();
                maxVal = Math.max(maxVal, temp.val);

                if(temp.left!= null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            finalAns.add(maxVal);
        }
        return finalAns;

    }
    public List<Integer> largestValues(TreeNode root) {
        q = new LinkedList<TreeNode>();
        finalAns = new ArrayList<Integer>();
        return solve(root);
    }
}