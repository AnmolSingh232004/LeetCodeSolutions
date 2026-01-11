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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null || root == null)return null;
        if (p.val == root.val || q.val == root.val)return root;
        if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }

    }
}

// if p and q are on opposite sides of any node it is the LCA
// if p and q are on same side we just try to find p or q and the moment we find p and q they are result
// to check if p and q are on left side which means p and q are smaller than curr node we can check the largest of two if its on left both are on left
// same for right side if the smallest of both is on right both are on right side