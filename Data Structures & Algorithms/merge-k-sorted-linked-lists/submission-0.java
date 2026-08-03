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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        ListNode initial = lists[0];
        for(int i=1;i<lists.length;i++){
            initial = merge(initial, lists[i]);
        }

        return initial;
    }

    private ListNode merge(ListNode list1, ListNode list2){
        ListNode newList = new ListNode(-1);
        ListNode temp = newList;
        while(list1 != null && list2 != null){
            ListNode newNode;
            if(list1.val <= list2.val){
                newNode = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                newNode = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp.next = newNode;
            temp = temp.next;
        }

        while(list1 != null){
            ListNode newNode = new ListNode(list1.val);
            temp.next = newNode;
            temp = temp.next;
            list1 = list1.next;
        }

        while(list2 != null){
            ListNode newNode = new ListNode(list2.val);
            temp.next = newNode;
            temp = temp.next;
            list2 = list2.next;
        }

        return newList.next;
    }
}
