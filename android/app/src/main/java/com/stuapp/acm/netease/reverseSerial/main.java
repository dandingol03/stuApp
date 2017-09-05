package com.stuapp.acm.netease.reverseSerial;


import java.util.Scanner;

public class main {

    static int[]arr;


    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=Integer.valueOf(sc.nextLine());
            arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();



            int j=arr.length-1;
            while(j>=0)
            {
                System.out.print(arr[j]);
                j=j-2;
                System.out.print(" ");
            }
            if(j==-2)
                j=1;
            else
                j++;
            while(j<arr.length)
            {
                System.out.print(arr[j]);
                j=j+2;
                if(j<arr.length)
                    System.out.print(" ");

            }




        }

    }
}
