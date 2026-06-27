/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int len1 = 0;
        while(temp1!=null){
            temp1 = temp1.next;
            len1++;
        }
        int len2 = 0;
        while(temp2!=null){
            temp2 = temp2.next;
            len2++;
        }
        temp1 = headA;
        temp2 = headB;
        if(len1 > len2){
            int x = len1-len2;
            for(int i = 0 ; i<x ; i++){
                temp1 = temp1.next;
            }
        } else{
            int x = len2 - len1;
            for(int i = 0 ; i<x ; i++){
                temp2 = temp2.next;
            }
        }
        while(temp1!=temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;

    }
}