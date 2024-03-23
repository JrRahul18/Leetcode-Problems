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
    ListNode current;
    public void rec(ListNode head){
        if(head == null)return;
        
        rec(head.next);
        
        ListNode temp = current.next;
        if(current.next == null){
            return;
        }
        else if(head == current){
            head.next = null;
            return;
        }
        
        current.next = head;
        if(temp == head){
            head.next = null;
        }
        else{
            head.next = temp;
        }
        current = temp;
        
    }
    public void reorderList(ListNode head) {
        current = head;
        rec(head);
    }
}