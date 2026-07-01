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
        while(list1!=null || list2!=null|| car!=0)
        {
            int v1=list1!=null ? list1.val:0;
            int v2=list2!=null ? list2.val:0;
            int sum=v1+v2+car;
            car=sum/10;
            val=sum%10;
            ListNode temp=new ListNode(val);
            node.next=temp;
            node=node.next;
            list1=list1!=null ? list1.next:null;
            list2=list2!=null ? list2.next:null;
        }
        
        return dummy.next;
        
    }

}
