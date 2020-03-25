/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }
        Node prev = head;
        Node cur = head.next;
        Node newNode = new Node(insertVal);
        
        while(cur != head){
            if(prev.val <= insertVal && insertVal <= cur.val){
                break;
            }else if(prev.val > cur.val){
                if(insertVal >= prev.val || insertVal <= cur.val){
                    break;
                }
            }
            prev = cur;
            cur = cur.next;
        }
        prev.next = newNode;
        newNode.next = cur;
        
        return newNode;
    }
}