/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pivot = head;
        ListNode leftDummy = new ListNode(-1);
        ListNode rightDummy = new ListNode(-1);
        partition(head, leftDummy, rightDummy);
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        
        //find left tail
        ListNode leftTail = left;
        while(leftTail!= null && leftTail.next != null){
            leftTail = leftTail.next;
        }
        if(leftTail == null){
            left = pivot;
        }else{
            leftTail.next = pivot;
        }
        
        pivot.next = right;
        return left;
    }
    
    private void partition(ListNode head, ListNode leftDummy, ListNode rightDummy){
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        
        int val = head.val;
        ListNode cur = head.next;
        
        while(cur != null){
            if(cur.val < val){
                left.next = cur;
                left = left.next;
            }else{
                right.next = cur;
                right = right.next;
            }
            cur = cur.next;
        }
        
        left.next = null;
        right.next = null;
    }
    
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}