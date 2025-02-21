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
class FindElements {
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
        recoverElements(root, 0);
    }
    private void recoverElements(TreeNode root, int currValue ) {
        if(root==null) return;
        root.val = currValue;
        recoverElements(root.left, currValue*2+1);
        recoverElements(root.right, currValue*2+2);

    }
    
    public boolean find(int target) {
        return find(this.root, target);
    }
    private boolean find(TreeNode root, int target) {
        if(root==null) return false;
        if(root.val == target) return true;
        boolean left = find(root.left, target);
        if(left) return true;
        boolean right = find(root.right, target);
        return right;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */