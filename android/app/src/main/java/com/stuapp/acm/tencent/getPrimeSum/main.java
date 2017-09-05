package com.stuapp.acm.tencent.getPrimeSum;


import java.util.Scanner;

public class main {

    private static boolean isPrime(int number)
    {
        for(int i=2;i<=number/2;i++)
        {
            if(number%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            Integer n=sc.nextInt();
            int count=0;
            for(int i=2;i<=n/2;i++)
            {
                int j=n-i;
                if(isPrime(i)&&isPrime(j))
                    count++;
            }
            System.out.println(count);
        }
    }
}
