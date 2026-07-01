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

        ListNode dummy= new ListNode(0,head);
        ListNode gPrev= dummy;

        while(true)
        {
            ListNode kNode= getKNode(gPrev, k);

            if(kNode==null)
            {
                break; // does not contains the K elements in group.
            }
            ListNode gNext=kNode.next;
            ListNode prev= kNode.next;
            ListNode cur= gPrev.next;

            // reversing the linkedlist 
            while(cur!=gNext)
            {
                ListNode next= cur.next;
                cur.next=prev;
                prev=cur;
                cur=next;
            }

            ListNode temp= gPrev.next;
            gPrev.next=kNode;
            gPrev=temp;
        }
        return dummy.next;
    }

    private ListNode getKNode(ListNode node, int k)
    {
        while(node != null && k>0)
        {
            node= node.next;
            k--;
        }
        return node;
        
    }
}
