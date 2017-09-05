package com.stuapp.acm.baidu.gobackHome;


import java.util.Scanner;

public class main {

    private static int getAbs(int a,int b)
    {
        if(a>=b)
            return a-b;
        else
            return b-a;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        //遍历看哪次步距忽略后的差距最大
        int max=0;
        int sum=0;


        for(int i=1;i<n-1;i++)
        {
            sum+=getAbs(arr[i],arr[i-1]);
            if(getAbs(arr[i-1],arr[i])+getAbs(arr[i],arr[i+1])-getAbs(arr[i-1],arr[i+1])>max)
            {
                max=getAbs(arr[i],arr[i-1])+getAbs(arr[i],arr[i+1])-getAbs(arr[i-1],arr[i+1]);
            }
        }
        if(n>2)
            sum+=getAbs(arr[n-1],arr[n-2]);

        System.out.println(sum-max);

    }
}
