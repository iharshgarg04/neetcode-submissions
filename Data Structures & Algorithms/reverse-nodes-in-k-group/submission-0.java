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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode prevPointer = dummyNode;
        ListNode initialPointer = head;
        ListNode temp = head;
        int count = 1;
        while(temp != null){
            if(count == k){
                ListNode next = temp.next;
                temp.next = null;

                ListNode reversed = reverse(initialPointer);

                prevPointer.next = reversed;
                initialPointer.next = next;

                prevPointer = initialPointer;
                initialPointer = next;
                temp = next;
                count = 1;
            } else {
                count++;
                temp = temp.next;
            }
        }

        return dummyNode.next;
    }

    private ListNode reverse(ListNode head){
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
