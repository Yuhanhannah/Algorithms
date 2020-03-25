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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null,null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }

        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }
        //left
        boolean leftValidator = helper(root.left, min, root.val);
        //right
        boolean rightValidator = helper(root.right, root.val, max);
        
        return (leftValidator && rightValidator);
        
    }
}