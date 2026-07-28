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
        ListNode dummy = new ListNode(0, head);
        ListNode gprev= dummy;

        while(true)
        {
            ListNode kNode= getKNode(gprev,k);
            if(kNode== null)    break;

            // reverse variable
            ListNode gnext= kNode.next;
            ListNode prev= kNode.next;
            ListNode cur= gprev.next;

            while(cur!=gnext)
            {
                ListNode next= cur.next;
                cur.next=prev;
                prev=cur;
                cur= next;
            } 

            ListNode temp= gprev.next;
            gprev.next= kNode;
            gprev= temp;

        }

        return dummy.next;
        
    }

    private ListNode getKNode(ListNode node, int k)
    {
        ListNode cur= node;
        while(cur!= null && k>0)
        {
            cur=cur.next;
            k--;
        }
        return cur;
    }
}
