package com.stuapp.acm.netease.numberGame;


import java.util.Arrays;
import java.util.Scanner;

public class main {

    private static int n;
    private static int[] arr;

    private static int calculateMinimum(int[] arr)
    {
        int sum=0;
        int j=0;
        //arr 下标
        int i=0;
        while(true)
        {
            if(i==sum)
                i++;
            else{
                while(i>sum&&j<arr.length)
                {
                    if(arr[j]==i)
                    sum+=arr[j++];
                }
                if(i==sum)
                {
                    i++;
                }
                else
                    return i;
            }
        }


    }

    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        while(in.hasNext())
        {
            n=in.nextInt();
            arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=in.nextInt();
            }
            //对数组进行排序
            Arrays.sort(arr);
            int re=calculateMinimum(arr);
            System.out.println(re);
        }
    }
}
