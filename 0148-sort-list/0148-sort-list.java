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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (int size = 1; size < n; size *= 2) {
            ListNode prev = dummy;
            ListNode curr = dummy.next;

            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, size);
                curr = split(right, size);

                prev = merge(left, right, prev);
            }
        }

        return dummy.next;
    }

    private ListNode split(ListNode head, int n) {
        if (head == null) return null;
        for (int i = 1; i < n && head.next != null; i++) {
            head = head.next;
        }
        ListNode second = head.next;
        head.next = null;
        return second;
    }

    private ListNode merge(ListNode l1, ListNode l2, ListNode prev) {
        ListNode curr = prev;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }
}