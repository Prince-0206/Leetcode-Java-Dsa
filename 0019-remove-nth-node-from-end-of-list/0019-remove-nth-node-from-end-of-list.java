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
        if(head.next == null){
            return null;
        }
        int i = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            i++;
        }
        int reqnode= i - n;
        ListNode prev = head;
        int z = 0;
        if(reqnode == 0) {
    return head.next;
}
        while(z<reqnode-1){
            prev = prev.next;
            z++;
        }
        prev.next = prev.next.next;
        return head;
    }
}