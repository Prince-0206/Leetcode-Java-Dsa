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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode findmiddle(ListNode head){
        ListNode rbit = head; 
        ListNode trtle = head;
        while(rbit.next != null && rbit.next.next != null){
            rbit = rbit.next.next;
            trtle = trtle.next;
        }
        return trtle;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode middle = findmiddle(head);
         ListNode nextstart = reverse(middle.next);

         ListNode firststart = head;
         while(nextstart !=null){
            if(firststart.val != nextstart.val){
                return false;
            }
            firststart = firststart.next;
            nextstart = nextstart.next;
         }
         return true;
    }
}