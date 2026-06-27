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
    public ListNode reverse( ListNode head){
        ListNode curr = head;
        ListNode prev= null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode middle(ListNode head){
        ListNode slow  = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public int pairSum(ListNode head) {
        if(head == null || head.next == null){
            return 0;
        }
        ListNode middle = middle(head);
        ListNode firstnext = reverse(middle.next);
        int sum = 0;
        while(firstnext != null){
            sum = Math.max(sum, head.val + firstnext.val); 
            head = head.next;
            firstnext = firstnext.next;
        }
        return sum;
    }
}