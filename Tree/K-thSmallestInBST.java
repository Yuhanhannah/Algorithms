/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int count;
    private int result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        result = -1;
        helper(root);
        return result;
    }
    private void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        count--;
        if(count == 0){
            result = root.val;
        }
        helper(root.right);
    }
}