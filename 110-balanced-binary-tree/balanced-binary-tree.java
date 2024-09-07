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
    public boolean isBalanced(TreeNode root){
        int [] x = logic(root);
        if (x[1] == 1)return true;
        else return false;
        }

    // int[0] == height
    // int[1] == if balanced or not (boolean)

    // 1 == true, -1 == false

    public int[] logic(TreeNode root) {
        if (root == null) return new int[]{0, 1}; //signifying tree is 0 height but balanced

        int[] res = new int[2];
        int[] left = logic(root.left); //0,1 // 1,1
        int[] right = logic(root.right); //0,1 //0,1

        int height = Math.max(left[0], right[0]) + 1; // + 1 to account for the node currently in stack
        res[0] = height;

        // Math.abs(left[0] - right[0]) is difference in height

        if (Math.abs(left[0] - right[0]) <= 1 && left[1] == 1 && right[1] == 1)
        res[1] = 1;
        else res[1] = 0;

        return res;
    }
}