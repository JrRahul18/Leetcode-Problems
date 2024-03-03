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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        temp = head;
        ListNode prevNode = null;
        int pointer = size-n;
        if(pointer == 0) return head.next;
        for(int i =0; i<pointer; i++){
            prevNode = temp;
            temp = temp.next;
        }
        prevNode.next = temp.next;
        return head;

    }
}