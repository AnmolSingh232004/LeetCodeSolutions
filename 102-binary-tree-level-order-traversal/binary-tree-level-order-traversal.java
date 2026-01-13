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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.size() != 0) {
            int size = q.size(); // this is imprt cause then i<queue.size can change
            List<Integer> localRes = new ArrayList<>();
            

            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();

                if (node != null) {
                localRes.add(node.val);
                if (node.left != null)q.add(node.left);
                if (node.right != null)q.add(node.right);
                }
            }
            if (localRes.size() > 0)res.add(localRes);
        }
        
        return res;
    }

    
}

// we can use a queue, initalizing it first with root
// for every level we can add every node on each level to queue
// and then we process these nodes
// we process a node by adding all nodes.val into our list and IMMEDAITELY REMOVE IT FROM THE QUEUE AND ADD ITS CHILDREN INSTEAD
// We do this until queue is empty