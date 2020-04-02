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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = inOrderTraverse(root1, target, new HashSet());
        return check(root2, set);
    }
    public Set<Integer> inOrderTraverse(TreeNode root, int target, Set<Integer> set){
        if(root == null){
            return set;
        }
        inOrderTraverse(root.left, target, set);
        set.add(target - root.val);
        inOrderTraverse(root.right, target, set);
        return set;
    }
    private boolean check(TreeNode root, Set<Integer> set){
        if(root == null){
            return false;
        }
        if(set.contains(root.val)){
            return true;
        }
        return check(root.left, set) || check(root.right, set);
    }
}