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
    public boolean recur(ListNode head){
        if(head == null){
            return true;
        }
        boolean temp = recur(head.next);
        if(head.val != current.val){
            return false;
        }
        current = current.next;
        return temp;
        
    }
    public boolean isPalindrome(ListNode head) {
        current = head;
        return recur(head);
        
    }
}