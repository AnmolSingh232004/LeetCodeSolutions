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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (queue.size() > 0) {
           
            List<Integer> local = new ArrayList<>();

            int limit = queue.size();
            for (int i=queue.size(); i>0; i--) {
            TreeNode curr = queue.poll();

            if (curr != null) {
                local.add(curr.val);
                queue.add(curr.left);
                queue.add(curr.right);
            }
            }
            if (local.size() > 0)
            res.add(local);
        }
        return res;
    }
}