/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }else if(m == n){
            return head;
        }
        //find the prev node
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode prevM = dummyHead;
        ListNode mNode = head;
        int index = 1;
        while(index < m){
            prevM = mNode;
            mNode = mNode.next;
            index++;
        }
        //start reverse
        ListNode prev = mNode;
        ListNode cur = prev.next;
        ListNode next= cur.next;
        index = m + 1;
        while(index <= n){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            index++;
        }
        
        prevM.next = prev;
        mNode.next = cur;
        
        return dummyHead.next;
        
    }
}