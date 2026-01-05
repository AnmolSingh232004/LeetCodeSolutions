/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node acts as a permanent predecessor to the head.
        // This allows uniform deletion logic even when the head itself is removed.
        ListNode dummy = new ListNode();
        dummy.next = head;

        // slow will always point to the node immediately BEFORE the target node.
        // fast is used only to maintain a fixed distance of n nodes from slow.
        // Both start at dummy so the distance invariant works for all cases,
        // including when the target node is the head (slow.next must always exist)..
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast forward by n steps to create a fixed gap of n nodes
        // between fast and slow.
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers together while preserving the gap.
        // When fast reaches the last node, slow is guaranteed to be
        // right before the target node.
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow.next is the target node.
        // Delete it by skipping exactly one node.
        slow.next = slow.next.next;

        // Return the possibly updated head.
        return dummy.next;
    }
}