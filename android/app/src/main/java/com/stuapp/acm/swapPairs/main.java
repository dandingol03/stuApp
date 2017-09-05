package com.stuapp.acm.swapPairs;


public class main {
    public static void main(String[] args)
    {
        ListNode f1=new ListNode(1);
        ListNode f2=new ListNode(2);
        ListNode f3=new ListNode(3);
        ListNode f4=new ListNode(4);
        f1.next=f2;
        f2.next=f3;
        f3.next=f4;
        Solution solution=new Solution();
        ListNode newList=solution.swapPairs(f1);
        System.out.println("......");

    }
}
