package com.stuapp.acm.didi.sequentMaxSum;


import java.util.Scanner;


/**
 * 逻辑,统计当前已遍历数字的总和
 * 1.当总和大于0时,可以继续和的累加计算
 * 2.当总和小于0时，则放弃进行重算
 * 3.重算时以当前数字计入
 */


public class main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            int n=Integer.valueOf(sc.nextLine());
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();

            //todo:求数组中的最大和
            if(arr.length==1)
                System.out.println(arr[0]);
            else{
                int max=arr[0];
                int sum=arr[0];

                for(int i=1;i<n;i++)
                {
                    if(sum>=0)
                    {
                        sum+=arr[i];
                        if(sum>max)
                            max=sum;
                    }else{
                        sum=arr[i];
                        if(sum>max)
                            max=sum;
                    }


                }
                System.out.println(max);
            }


        }
    }
}
