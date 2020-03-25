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
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        traverse(root);
        return result;
    }
    private void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        result.add(root.val);
        traverse(root.right);
    }
}