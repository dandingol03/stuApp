package com.stuapp.acm.netease.maxOdd;


import java.util.Scanner;

public class main {

    private static int getMaxOdd(int number)
    {
        int r=number;
        while(r%2==0)
        {
            r=r/2;
        }
        return r;
    }

    public static void main(String[] args)
    {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        for(int i=1;i<=n;i++)
        {
            if(i%2==0)
            {
                sum+=getMaxOdd(i);
            }else{
                sum+=i;
            }
        }
        System.out.println(sum);
    }
}
