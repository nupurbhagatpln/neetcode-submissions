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
        int size=linkedListSize(head);
        int target=size-n;

        ListNode prev=head, cur=head;
        if(target==0) return head.next;
        while(target>0)
        {
            target--;
            prev=cur;
            cur=cur.next;
        }
        prev.next=cur.next;
        return head;

    }

    public int linkedListSize(ListNode head)
    {
        int count=0;
        while(head!=null)
        {
            count++;
            head=head.next;
        }
        return count;
    }
}
