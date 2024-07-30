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
    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode();
        ListNode dummy = res;
        head = head.next;

        while (head != null) {
            int localSum = 0;
            while (head.val != 0) {
                localSum += head.val;
                head = head.next;
            }
            if (localSum > 0) {
            res.next = new ListNode(localSum);
            res = res.next;
            }
            head = head.next;
        }
            return dummy.next;
    }
    }

