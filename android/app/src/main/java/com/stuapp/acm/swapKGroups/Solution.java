package com.stuapp.acm.swapKGroups;



public class Solution {

    public ListNode reverseKList(ListNode head,int k)
    {
        ListNode front=null;
        ListNode end=null;
        if(head!=null)
        {
            int count=1;
            front=head;
            end=head.next;
            if(end!=null)
            {
            }else{
                return front;
            }
            while(end!=null&&count<k)
            {
                ListNode temp=end.next;
                end.next=front;
                front=end;
                end=temp;
                count++;
            }

        }
        return front;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        //TODO:倒序一个k长度的链表
        if(head!=null)
        {
            ListNode p=reverseKList(head,k);
            while(p.next!=null)
            {
                ListNode prefix=p;
                p=reverseKList(p.next,k);
                prefix.next=p;
            }
        }

        return head;
    }
}
