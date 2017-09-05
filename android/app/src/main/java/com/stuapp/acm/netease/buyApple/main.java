package com.stuapp.acm.netease.buyApple;


import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=0;
        int q=n/8;
        if(n<8)
        {
            if(n==6)
                System.out.println(1);
            else
                System.out.println(-1);
        }else{
            while((p*6+q*8)!=n&&q>=0)
            {
                q--;
                p=(n-8*q)/6;
            }
            if((p*6+q*8)==n)
                System.out.println(p+q);
            else
                System.out.println(-1);
        }
    }
}
