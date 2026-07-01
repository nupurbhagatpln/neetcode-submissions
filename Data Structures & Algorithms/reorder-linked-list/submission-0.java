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
        int size=linkedListSize(head);
        System.out.println("size "+ size);
        ListNode list1=head;
        ListNode list2=head;
        int t=0;
        while(t<(size/2))
        {
            list2=list2.next;
            t++;
        }
        
        ListNode list3= reverseList(list2.next);
        list2.next=null;
        ListNode dummy= new ListNode(0);
        ListNode node=dummy;

        while(list1!=null && list3!=null)
        {
            node.next=list1;
            list1=list1.next;
            node=node.next;
            node.next=list3;
            list3=list3.next ;
            node=node.next;  
        }
        if(list1!=null)
        {
            node.next=list1;
        }
        else if(list3!=null)
        {
            node.next=list3;
        }
        
        
    }
    public int linkedListSize(ListNode head)
    {
        ListNode cur=head;
        int count=0;
        while(cur!=null)
        {
            count++;
            cur=cur.next;
        }
        return count;
    }
    public ListNode reverseList(ListNode head){
        ListNode prev=null, cur=head;

        while(cur!=null)
        {
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}
