package com.stuapp.acm.addTwoNumbers;


public class main {


    public static void main(String[] args){

        ListNode list1=new ListNode(2);
        ListNode a1=new ListNode(4);
        ListNode a2=new ListNode(3);

        ListNode list2=new ListNode(5);
        ListNode b1=new ListNode(6);
        ListNode b2=new ListNode(4);
        list1.next=a1;
        a1.next=a2;
        list2.next=b1;
        b1.next=b2;


        ListNode newList=Solution.addTwoNumbers(list1,list2);
        System.out.println(newList);

    }
}
