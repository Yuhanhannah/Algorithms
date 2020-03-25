/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int x = s1.isEmpty() ? 0 : s1.pop();
            int y = s2.isEmpty() ? 0 : s2.pop();
            int sum = carry + x + y;
            carry = sum / 10;
            s3.push(sum % 10);
        }
        
        if(carry == 1){
            s3.push(1);
        }
        
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        
        while(!s3.isEmpty()){
            cur.next = new ListNode(s3.pop());
            cur = cur.next;
        }
        
        return dummyHead.next;
    }
}