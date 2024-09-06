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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hset = new HashSet<>();
        for(int num:nums){
            hset.add(num);
        }
        
        while(head != null && hset.contains(head.val)){
            head = head.next;
        }
        ListNode prev = head;
        ListNode current = head;
        
        while(current != null){
            if(hset.contains(current.val)){
                prev.next = current.next;
                current = current.next;
            }
            else{
                prev = current;
                current = current.next;
            }
        }
        return head;
        
    }
}