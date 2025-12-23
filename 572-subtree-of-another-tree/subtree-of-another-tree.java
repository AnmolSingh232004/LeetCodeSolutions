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
        if (subRoot == null)return true; //if subRoot is null and tree is not it means it has to be subTree since its empty
        // very impt since once subRoot is fully traversed we will know the answer and since we use isSubtree on both left and right
        //it ensures that 
        if (root == null) return false; //Assuming subRoot is not null since checked in first case which means subRoot is not null

        if(sameTree(root, subRoot))return true; //simply checks if the given trees are same or not

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        //we compare both sides so then the first subRoot == null actually makes sense
    }

    public boolean sameTree(TreeNode root, TreeNode subRoot) { // helper which tells if  2 tree are same or not
        if (root == null && subRoot == null)return true;
        if (root != null && subRoot == null || root == null && subRoot != null)return false;
        if (root != null && subRoot != null && root.val != subRoot.val)return false;

        return (sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right));
    }
}