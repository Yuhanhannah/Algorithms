/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        ListNode midNode = findMiddle(head);
        ListNode secondHead = midNode.next;
        
        midNode.next = null;    
        
        ListNode reversedSecondHead = reverseLinkedList(secondHead);
        
        ListNode p1 = head;
        ListNode p2 = reversedSecondHead;
        while(p1 != null && p2 != null){
            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;
            p1.next = p2;
            p2.next = p1Next;
            p1 = p1Next;
            p2 = p2Next;
        }
        
        return;
    }
    private ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
      
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
