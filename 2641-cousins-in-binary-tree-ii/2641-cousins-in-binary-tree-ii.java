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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> lst = new ArrayList<>();
        
         while (!q.isEmpty()) {
            int current = 0;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = q.peek();
                q.poll();
                current += temp.val;
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            lst.add(current);
        }
        
        q.add(root);
        root.val = 0;  // root has no cousins
        int level = 1;
        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode temp = q.peek();
                q.poll();
                int childSum = 0;
                if(temp.left != null) childSum+=temp.left.val;
                if(temp.right != null) childSum+=temp.right.val;
                
                if(temp.left != null){
                    temp.left.val = lst.get(level) - childSum;
                    q.add(temp.left);
                }
                
                if(temp.right != null){
                    temp.right.val = lst.get(level) - childSum;
                    q.add(temp.right);
                }
            }
            
            level++;
        }

        return root;

    }
}