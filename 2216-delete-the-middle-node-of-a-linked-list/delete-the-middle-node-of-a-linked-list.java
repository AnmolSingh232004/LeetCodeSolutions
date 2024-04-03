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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)return head.next;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode mid = head;
        ListNode fast = head;
        ListNode midB = head;
        mid = mid.next;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            midB = midB.next;
            mid = mid.next;
            fast = fast.next.next;
        }
        midB.next = mid.next;

        return dummy.next;
    }
}