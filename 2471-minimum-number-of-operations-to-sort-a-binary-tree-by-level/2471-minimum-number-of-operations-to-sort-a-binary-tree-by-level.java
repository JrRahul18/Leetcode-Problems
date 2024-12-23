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
    
    public int minimumOperations(TreeNode root) {
        int finalAns=0;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            HashMap<Integer, Integer> hmap = new HashMap<>();
            List<Integer> lst = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode temp = q.peek();
                q.poll();
                lst.add(temp.val);
                
                hmap.put(temp.val, i);
                
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            
            List<Integer> newlst = new ArrayList<>(lst);
            Collections.sort(newlst);
            
            for(int i=0; i<lst.size(); i++){
                if(lst.get(i).equals(newlst.get(i)) ){
                    continue;
                }
                
                int sortIdx = hmap.get(newlst.get(i));
                hmap.put(lst.get(i), sortIdx);
                hmap.put(lst.get(sortIdx), i);
                Collections.swap(lst, sortIdx, i);
                finalAns++;
            }
            
            
        }
        return finalAns;
    }
}