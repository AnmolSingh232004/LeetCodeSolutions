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
    int res = 0;

    public int goodNodes(TreeNode root) {
        good(root, root.val);
        return res;
    }

    public int good(TreeNode root, int max) {
        if (root == null)return 0;
        if (root.val > max)max = root.val;

        if (root.val >= max)res++;

        good(root.left, max);
        good(root.right, max);

        return 0;
    }
}

// for each node it has to be greater than or equal to the greatest parent node it has
// we can have a max node varaible to which we compare each child node if greater we add 1 to res