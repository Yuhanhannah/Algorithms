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
    public int closestValue(TreeNode root, double target) {
        if(root == null){
            return -1;
        }
        
        int lower = root.val;
        int upper = root.val;
        
        while(root != null){
            if(root.val == target){
                return root.val;
            }else if(root.val < target){
                lower = root.val;
                root = root.right;
            }else if(root.val > target){
                upper = root.val;
                root = root.left;
            }
        }
        
        
        return Math.abs(upper - target) < Math.abs(target - lower) ? upper : lower;
    }
}
//最后要判断一下绝对值，因为如果是 1 - null - 2 的话， upper - target = 1 - 3.5 = -2.5 负数就会小很多
