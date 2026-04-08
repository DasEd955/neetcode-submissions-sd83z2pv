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
    public int goodNodes(TreeNode root) {
        
        if(root.left == null && root.right == null) {return 1;}

        return this.dfs(root, root.val);
    }

    public int dfs(TreeNode node, int maxVal) {

        if(node == null) {return 0;}
        
        int count = (node.val >= maxVal) ? 1 : 0;
        maxVal = Integer.max(maxVal, node.val);
        int left = dfs(node.left, maxVal), right = dfs(node.right, maxVal);
        count += left;
        count += right;

        return count;
    }   
}
