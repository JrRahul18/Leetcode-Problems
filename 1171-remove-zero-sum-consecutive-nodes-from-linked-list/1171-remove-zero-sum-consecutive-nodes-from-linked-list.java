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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> hmap = new HashMap<>();
        int prefSum = 0;
        ListNode tempnode = new ListNode(0);
        tempnode.next = head;
        
        hmap.put(prefSum, tempnode);
        
        while(head != null){
            prefSum+=head.val;
            if(hmap.containsKey(prefSum)){
                ListNode start = hmap.get(prefSum);
                ListNode temp = start;
                int tempSum = prefSum;
                while(temp != head){
                    temp = temp.next;
                    tempSum+=temp.val;
                    if(temp != head){
                        hmap.remove(tempSum);
                    }
                }
                start.next = head.next;
            }else{
                hmap.put(prefSum, head);
            }
            head = head.next;
        }
        return tempnode.next;
        
    }
}