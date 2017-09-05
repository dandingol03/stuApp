package com.stuapp.acm.meituan.zillionaire;


import java.util.Scanner;

public class main {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=sc.nextInt();
            Double d=Math.pow(2,n-1);
            System.out.println(d.intValue());

        }
    }
}
