package com.stuapp.acm.jd.average;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    static List<Integer> inputs=new ArrayList<>();

    static int calculateSum(int n,int radix)
    {
        int sum=0;
        while(n>0)
        {
            sum+=n%radix;
            n=n/radix;
        }
        return sum;
    }

    static String makeEase(int x,int y)
    {

        if(y==1)
            return x+"/"+y;
        boolean flag=true;
        while(flag)
        {
            int j=1;
            for(int i=2;i<=y;i++)
            {
                if(y%i==0&&x%i==0)
                    j=i;
            }
            if(j!=1)
            {
                x=x/j;
                y=y/j;
            }else{
                flag=false;
            }
        }
        return x+"/"+y;
    }

    public static void main(String[] args)
    {
//        Scanner sc=new Scanner(System.in);
//        inputs.clear();
//        while(sc.hasNext())
//        {
//            int n=sc.nextInt();
//            inputs.add(n);
//        }
        inputs.add(10);

        if(inputs.size()>0)
        {
            for(int i=0;i<inputs.size();i++)
            {
                int number=inputs.get(i);
                int sum=0;
                for(int j=2;j<number;j++)
                {
                    sum+=calculateSum(number,j);
                }

                System.out.println(makeEase(sum,number-2));

            }
        }
    }
}
