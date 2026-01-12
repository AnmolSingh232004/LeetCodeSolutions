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
    List<Integer> list = new ArrayList<>();

    public int smallest(List<Integer> list, int k) {
        for (int i=0; i<list.size(); i++) {
            if (i == k-1)return list.get(i);
        }
        return -1;
    }

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return smallest(list, k);
    }

    public void inOrder(TreeNode root) {
        if (root == null)return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}