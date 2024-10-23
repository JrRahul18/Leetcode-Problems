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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> levelSum = new ArrayList<>();
        
         while (!queue.isEmpty()) {
            int currLevelSum = 0;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                currLevelSum += curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            levelSum.add(currLevelSum);
        }
        
        queue.add(root);
        root.val = 0;  // root has no cousins
        int level = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();

                // levelSum of currentLevel - siblingSum
                int siblingSum = (curr.left != null ? curr.left.val : 0) + (curr.right != null ? curr.right.val : 0);

                if (curr.left != null) {
                    curr.left.val = levelSum.get(level) - siblingSum;
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = levelSum.get(level) - siblingSum;
                    queue.add(curr.right);
                }
            }
            level++;
        }

        return root;

    }
}