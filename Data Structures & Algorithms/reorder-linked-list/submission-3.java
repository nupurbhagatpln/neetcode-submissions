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

        ListNode slow= head, fast= head.next;

        while(fast!= null && fast.next!=null)
        {
            slow= slow.next;
            fast= fast.next.next;
        }
        ListNode sec= slow.next;
        slow.next= null;

        ListNode prev= reverseList(sec);

        ListNode l1=head, l2=prev;

        while(l2!=null)
        {
            ListNode t1= l1.next;
            ListNode t2= l2.next;
            l1.next= l2;
            l2.next= t1;
            l1=t1;
            l2=t2;
        }  
    }

    private ListNode reverseList(ListNode head)
    {
        ListNode cur= head, prev= null;

        while(cur!=null)
        {
            ListNode next= cur.next;
            cur.next=prev;
            prev= cur;
            cur=next;
        }
        return prev;
    }
}
