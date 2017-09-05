package com.stuapp.acm.mergeLists;


public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head=null;
        ListNode p=null;
        ListNode head1=l1;
        ListNode head2=l2;
        while(head1!=null&&head2!=null)
        {
            int x=0;
            if(head1.val<=head2.val)
            {
                x=head1.val;
                head1=head1.next;
            }else{
                x=head2.val;
                head2=head2.next;
            }
            if(head==null)
            {
                head=new ListNode(x);
                p=head;
            }else{
                p.next=new ListNode(x);
                p=p.next;
            }
        }


        if(head1!=null)
        {
            if(p!=null)
                p.next=head1;
            else
                head=head1;
        }else if(head2!=null)
        {
            if(p!=null)
                p.next=head2;
            else
                head=head2;
        }else{
        }

        return head;

    }
}
