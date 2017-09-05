package com.stuapp.acm.netease.radiusCircle;


import java.util.Scanner;



public class main {

    private  static int calculateCount(int product)
    {
        int count=0;
        for(int x=0;x<Math.sqrt(product);x++)
        {
            int yProduct=product-x*x;
            if((Math.sqrt(yProduct)*10)%10==0)
                count++;
        }

        return count;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int product=sc.nextInt();
            int re=calculateCount(product);
            System.out.println(4*re);
        }
    }
}
