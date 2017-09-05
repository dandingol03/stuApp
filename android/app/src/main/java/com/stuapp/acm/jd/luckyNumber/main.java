package com.stuapp.acm.jd.luckyNumber;


import java.util.Scanner;

public class main {

    private static boolean isLucky(int number)
    {
        int t=number;
        int bSum=0;
        int dSum=0;
        while(t>0)
        {
            int r=t%10;
            dSum+=r;
            t=t/10;
        }
        t=number;
        while (t>0)
        {
            int r=t%2;
            bSum+=r;
            t=t/2;
        }
        if(bSum==dSum)
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=sc.nextInt();
            int count=0;
            for(int i=1;i<=n;i++)
            {
                if(isLucky(i))
                    count++;
            }
            System.out.println(count);
        }
    }
}
