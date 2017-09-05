package com.stuapp.acm.sohu.rohanTower;


import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            int n=Integer.valueOf(sc.nextLine());
            int []wg=new int[n];
            int []hi=new int[n];
            for(int i=0;i<n;i++)
            {
                sc.nextInt();
                wg[i]=sc.nextInt();
                hi[i]=sc.nextInt();
            }



            //todo:1.对于n个人的体重进行排序,那么应该从体重最轻的身高最矮的开始,这里的话同个体重应该维持一个链表


        }
    }
}
