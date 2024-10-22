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
    public long kthLargestLevelSum(TreeNode root, int k) {
        long finalAns = -1;
        if(root == null) return finalAns;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q =new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            long currentSum = 0;
            
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode temp  = q.peek();
                q.poll();
                currentSum+=temp.val;
                
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
                
            }
            pq.offer(currentSum);
            if(pq.size() > k) pq.poll();
        }
        if(pq.size() < k) return finalAns;
        return pq.peek();
    }
}