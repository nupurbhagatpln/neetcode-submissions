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
        ListNode slow=head, fast=head.next;

        while(fast!=null && fast.next!=null)
        {
            slow= slow.next;
            fast=fast.next.next;
        }

        ListNode second=slow.next;
        ListNode prev=null;
        slow.next=null;

        // Reverse the linked list

        while(second!=null)
        {
            ListNode temp= second.next;
            second.next=prev;
            prev=second;
            second=temp;
        }
        ListNode list1=head, list2=prev;

        while(list2!=null)
        {
            ListNode t1= list1.next;
            ListNode t2= list2.next;
            list1.next=list2;
            list2.next=t1;
            list1=t1;
            list2=t2;
        }
        
    }
}
