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
        if(head==null || head.next==null){
            return;
        }
        ListNode mid = findMid(head);
        ListNode reversed = reverseList(mid.next);
        mid.next = null;
        ListNode temp = head;
        while(temp != null && reversed != null){
            ListNode tempNext = temp.next;
            ListNode reversedNext = reversed.next;
            temp.next = reversed;
            reversed.next = tempNext;
            temp = tempNext;
            reversed = reversedNext;
        }
    }

    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode mid){
        ListNode prev = null;
        while(mid != null){
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }
        return prev;
    }
}