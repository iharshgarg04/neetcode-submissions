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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Reverse = reverseList(l1);
        ListNode l2Reverse = reverseList(l2);
        int carry=0;
        ListNode newList = new ListNode(-1);
        ListNode temp = newList;
        while(l1Reverse != null && l2Reverse != null){
            int val1 = l1Reverse.val;
            int val2 = l2Reverse.val;
            int addition = val1+val2;
            carry = addition/10;
            ListNode node = new ListNode(addition%10 + carry);
            temp.next = node;
            temp = temp.next;
            l1Reverse = l1Reverse.next;
            l2Reverse = l2Reverse.next;
        }
        // if(carry > 0){
        //     ListNode node = new ListNode(carry);
        //     temp.next = node;
        //     temp = temp.next;
        // }
        return reverseList(newList.next);
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
