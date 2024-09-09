/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] finalAns = new int[m][n];
        for(int i=0; i<finalAns.length; i++){
            Arrays.fill(finalAns[i], -1);
        }
        
        int d = 0;
        int top=0, bottom=m-1, left=0, right=n-1;
        
        while(top <=bottom && left<=right){
            if(d==0){
                for(int j=left; head!= null && j<=right; j++){
                    finalAns[top][j] = head.val;
                    head = head.next;
                }
                top++;
            }
            if(d==1){
                for(int i=top; head!= null && i<=bottom; i++){
                    finalAns[i][right]=head.val;
                    head=head.next;
                }
                right--;
            }
            
            if(d==2){
                for(int j = right; head != null && j >=left; j--){
                    finalAns[bottom][j] = head.val;
                    head = head.next;
                }
                bottom--;
            }
            
            if(d == 3){
                for(int i=bottom; head!= null && i>= top; i--){
                    finalAns[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }
            d = (d+1)%4;
        }
        return finalAns;
        
        
    }
}