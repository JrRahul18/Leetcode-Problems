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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int level=0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            List<TreeNode> nodelst = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                TreeNode temp = q.peek();
                q.poll();
                nodelst.add(temp);
                
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            
            if(level%2 != 0){
                int l=0, r=nodelst.size()-1;
                while(l<r){
                    int temp=nodelst.get(l).val;
                    nodelst.get(l).val=nodelst.get(r).val;
                    nodelst.get(r).val=temp;
                    l++;
                    r--;
                }
            }
            level++;
        }
        return root;
    }
}