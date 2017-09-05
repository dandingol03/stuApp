package com.stuapp.acm.netease.friend;


import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int a1=sc.nextInt();
        int a2=sc.nextInt();
        int a3=sc.nextInt();
        int a4=sc.nextInt();

        if((a1+a3)%2==0)
        {
            int a=(a1+a3)/2;
            int b=a3-a;
            int c=a4-b;
            if(a>=0&&b>=0&&c>=0)
            {
                System.out.print(a);
                System.out.print(" ");
                System.out.print(b);
                System.out.print(" ");
                System.out.print(c);
            }else{
                System.out.println("No");
            }
        }else{
            System.out.println("No");
        }



    }
}
