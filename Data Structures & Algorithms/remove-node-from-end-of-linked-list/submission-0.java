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
        ListNode reverse = reverseList(head);
        int count =1;
        ListNode temp = reverse;
        if (n==1) return reverseList(temp.next);
        while(temp!=null && count != n-1){
            temp = temp.next;
            count++;
        }
        temp.next = temp.next.next;
        return reverseList(reverse);
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
