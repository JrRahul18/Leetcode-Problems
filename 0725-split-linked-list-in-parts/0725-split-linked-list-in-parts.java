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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] finalAns = new ListNode[k];

        int n = 0;
        ListNode current = head;
        while(current!= null){
            n++;
            current = current.next;
        }
        int size = n/k;
        int rem = n%k;
        current = head;
        ListNode prev = null;

        for(int i = 0; i<k;i++){
            finalAns[i] = current;
            for(int j = 1; j<=size + (rem>0 ? 1 : 0); j++){
                prev = current;
                current = current.next;
            }
            
            System.out.println(current != null ? current.val: 0);
            if(prev!= null){
                prev.next = null;
            }
            rem--;
            
        }
        return finalAns;
    }
}