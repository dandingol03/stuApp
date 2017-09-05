package com.stuapp.acm.swapPairs;



public class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode p=null;
        ListNode f1=null;
        if(head!=null)
            p=head;
        ListNode sentinel=null;
        while(p!=null)
        {

            f1=p.next;
            if(sentinel==null)
            {
                //对应p为首节点
                if(f1!=null)
                {
                    p.next=f1.next;
                    f1.next=p;
                    head=f1;
                    sentinel=p;
                    p=sentinel.next;
                }

            }else{
                //对应p不为首结点
                if(f1!=null)
                {
                    p.next=f1.next;
                    sentinel.next=f1;
                    f1.next=p;
                    sentinel=p;
                    p=sentinel.next;

                }
            }


        }

        return head;
    }
}
