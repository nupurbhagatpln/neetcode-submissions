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
        
        ListNode list1= l1;
        ListNode list2= l2;
        int carry=0;
        ListNode dummy= new ListNode(0);
        ListNode prev= dummy;
        while(list1 != null  || list2!= null)
        {
            int val1= list1!=null ? list1.val: 0;
            int val2= list2!= null ? list2.val: 0;
            int sum= val1+val2+carry;
            carry= sum/10;
            int val= sum%10;
            prev.next= new ListNode(val);;
            prev= prev.next;
            list1= list1!=null? list1.next: null;
            list2= list2!= null ? list2.next : null;
        }

        if(carry!=0)
        {
            prev.next= new ListNode(carry);
            System.out.println("csarry " + carry + " " +prev.val +" "+ prev.next.val);
        }
        return (dummy.next);

    }

    private ListNode reverseList(ListNode head)
    {
        ListNode prev= null, cur= head;

        while(cur!= null)
        {
            ListNode next= cur.next;
            cur.next= prev;
            prev= cur;
            cur= next;
        }
        return prev;
    }
}
