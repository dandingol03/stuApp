package com.stuapp.acm.addTwoNumbers;


public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1=l1;
        ListNode head2=l2;
        ListNode list=null;
        ListNode head=null;
        int flag=0;
        while(head1!=null&&head2!=null)
        {
            int  val1=head1.val;
            int  val2=head2.val;
            ListNode temp=new ListNode((val1+val2+flag)%10);
            if(val1+val2+flag>=10)
                flag=1;
            else
                flag=0;
            if(list==null)
            {
                list=temp;
                head=list;
            }else{
                head.next=temp ;
                head=head.next;
            }
            head1=head1.next;
            head2=head2.next;
        }
        ListNode remain=null;
        if(head1!=null)
        {
            remain=head1;
        }else if(head2!=null)
        {
            remain=head2;
        }

        while(remain!=null)
        {
            int val=remain.val;
            ListNode temp=new ListNode((val+flag)%10);
            if(val+flag>=10)
                flag=1;
            else
                flag=0;
            if(head!=null)
                head.next=temp;
            remain=remain.next;
            if(head!=null)
                head=head.next;
        }
        if(flag==1)
            head.next=new ListNode(1);


        return list;

    }
}
