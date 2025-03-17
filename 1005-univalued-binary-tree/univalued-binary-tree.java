/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        boolean left = true;
        boolean right = true;
        if(root.left!=null){
            if(root.left.val!=root.val) return false;
            left = isUnivalTree(root.left);
        }
        if(root.right!=null){
            if(root.right.val!=root.val) return false;
            right = isUnivalTree(root.right);
        }
        return left&&right;
    }
}