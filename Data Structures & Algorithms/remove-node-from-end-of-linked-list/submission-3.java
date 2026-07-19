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

        int size=0;
        ListNode cur= head;
        while(cur!= null)
        {
            size++;
            cur= cur.next;
        }
        int k= size- n +1;
        cur= head;
        ListNode dummy= new ListNode(0);
        ListNode prev= dummy;
        for(int i=1;i<k;i++)
        {
            prev.next=cur;
            prev=prev.next;
            cur=cur.next;
        }
        prev.next=cur.next;
        return dummy.next;


    }
}
