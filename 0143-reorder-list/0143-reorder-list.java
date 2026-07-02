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
    public void reorderList(ListNode head) {
         if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextstart = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(nextstart!=null){
            ListNode temp = nextstart.next;
            nextstart.next = prev;
            prev = nextstart;
            nextstart = temp;
        }
        ListNode first = head;
        ListNode second  = prev;
        while(second!=null){
            ListNode tmp = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp;
            first = tmp;
            second = tmp2;
        }
    }
}