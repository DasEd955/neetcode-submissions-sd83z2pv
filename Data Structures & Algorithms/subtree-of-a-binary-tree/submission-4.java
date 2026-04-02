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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null || subRoot == null) {return root == subRoot;}

        boolean leftFound = this.isSubtree(root.left, subRoot), rightFound = this.isSubtree(root.right, subRoot);

        return this.sameTree(root, subRoot) || leftFound != false || rightFound != false;
    }

    public boolean sameTree(TreeNode root, TreeNode subRoot) {

        if(root == null || subRoot == null) {return root == subRoot;}

        boolean leftMatch = this.sameTree(root.left, subRoot.left), rightMatch = this.sameTree(root.right, subRoot.right);

        return root.val == subRoot.val && leftMatch != false && rightMatch != false;
    }
}
