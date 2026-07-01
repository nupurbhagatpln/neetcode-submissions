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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode list1=l1;
        ListNode list2=l2;
        ListNode dummy=new ListNode(0);
        ListNode node=dummy;
        int val=0, car=0;
        while(list1!=null &&list2!=null)
        {
            int sum=list1.val+list2.val+car;
            car=sum/10;
            val=sum%10;
            System.out.println("sum" + sum + " car"+ car);
            ListNode temp=new ListNode(val);
            node.next=temp;
            node=node.next;
            list1=list1.next;
            list2=list2.next;
        }
        while(list1!=null)
        {
            int sum=list1.val+car;
            car=sum/10;
            val=sum%10;
            ListNode temp=new ListNode(val);
            node.next=temp;
            node=node.next;
            list1=list1.next;

        }
        while(list2!=null)
        {
            int sum=list2.val+car;
            car=sum/10;
            val=sum%10;
            ListNode temp=new ListNode(val);
            node.next=temp;
            node=node.next;
            list2=list2.next;
        }
        if(car>0)
        {
            ListNode temp=new ListNode(car);
            node.next=temp;
            node=node.next;
        }
        return dummy.next;
        
    }

    public ListNode reverseList(ListNode head)
    {
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
