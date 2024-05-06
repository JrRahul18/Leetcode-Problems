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
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode lastNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }
    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);
        
        int countMax = -1;
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            countMax = Math.max(countMax, current.val);
            if(current.val < countMax){
                prev.next = current.next;
                ListNode temp = current;
                current = current.next;
                temp.next = null;
            }
            else{
                prev = current;
                current = current.next;
            }
        }
        return reverseList(head);
    }
}