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

        ListNode dummy= new ListNode(0, head);
        ListNode grpPrev=dummy;

        while(true)
        {
            ListNode kNode=getKNode(grpPrev,k);
            // do nothing
            if(kNode==null) break;

            ListNode grpNext=kNode.next;

            ListNode prev=kNode.next;
            ListNode curr=grpPrev.next;

            // reversing the linked list
            while(curr!=grpNext)
            {
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }

            // changing the grpPrev to the new node
            ListNode temp=grpPrev.next;
            grpPrev.next=kNode;
            grpPrev=temp;

        }
        
        return dummy.next;
    }

    private ListNode getKNode(ListNode curr, int k)
    {
        while(curr!=null && k>0)
        {
            curr=curr.next;
            k--;
        }
        return curr;
    }
}
