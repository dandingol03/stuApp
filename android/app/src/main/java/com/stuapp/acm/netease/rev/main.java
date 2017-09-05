package com.stuapp.acm.netease.rev;


import java.util.Scanner;

public class main {

    private static int rev(int number)
    {
        String re="";
        while(number>0)
        {
            re=re+number%10;
            number=number/10;
        }
        return Integer.valueOf(re);
    }

    public static void main(String[] args)
    {

        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int re=rev(x)+rev(y);
        re=rev(re);
        System.out.println(re);

    }

}
