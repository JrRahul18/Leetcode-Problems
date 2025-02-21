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
class FindElements {
    static HashSet<Integer> hset = new HashSet<>();
    static void dfs(TreeNode root, int num){
        if(root == null) return;

        root.val = num;
        hset.add(num);

        if(root.left != null){
            dfs(root.left, (2*num) + 1);
        }

        if(root.right != null){
            dfs(root.right, (2*num) + 2);
        }
    }

    public FindElements(TreeNode root) {
        hset.clear();
        dfs(root, 0);
        
    }
    
    public boolean find(int target) {
        return hset.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */