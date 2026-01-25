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
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        bfs(root, queue);
        return res;
    }

    public void bfs(TreeNode root, Queue<TreeNode> queue) {

        while (!queue.isEmpty()) {
            int size = queue.size(); // nodes at current level

            for (int i=0; i<size; i++) {

            TreeNode temp = queue.poll();

            if (temp != null) {
                if (size - i == 1)res.add(temp.val);
                if (temp.left != null)queue.add(temp.left);
                if (temp.right != null)queue.add(temp.right);
            }

            }
            
        }
    }
}