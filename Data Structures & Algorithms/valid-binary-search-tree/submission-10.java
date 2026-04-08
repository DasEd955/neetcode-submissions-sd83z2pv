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
    double min = Double.NEGATIVE_INFINITY, max = Double.POSITIVE_INFINITY;

    public boolean isValidBST(TreeNode root) {

        if(root.left == null && root.right == null) {return true;}

        return this.dfs(root, min, max);
    }

    public boolean dfs(TreeNode node, double leftVal, double rightVal) {

        if(node == null) {return true;}

        boolean left = this.dfs(node.left, leftVal, node.val), right = this.dfs(node.right, node.val, rightVal);

        return (left == true) && (right == true) && (node.val > leftVal) && (node.val < rightVal);
    }
}
