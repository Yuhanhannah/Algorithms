/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null || val <= 0){
            return head;
        }
    
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head; 
        
        while(cur != null){
            if(cur.val != val){
                prev = cur;
                cur = cur.next;
            }else{
                prev.next = cur.next;
                cur = prev.next;
            }
        }
    
        return dummy.next;
    }
}