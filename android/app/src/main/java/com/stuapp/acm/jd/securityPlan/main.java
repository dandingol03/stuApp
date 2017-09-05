package com.stuapp.acm.jd.securityPlan;


import java.util.Scanner;

public class main {

    static int HIGHER=1;
    static int LOWER=-1;

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            int n=Integer.valueOf(sc.nextLine());
            int []arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();

            int sum=0;
            for(int i=0;i<n-1;i++)
            {
                int count=1;
                //作为后继山峰
                int max=arr[i+1];

                //保存最高的山峰
                for(int j=i+2;j<n;j++)
                {
                    int curHigh=arr[j];
                    if(curHigh>max||arr[i]>max){
                        count++;
                        if(curHigh>max)
                            max=curHigh;
                    }else if(arr[i]==max&&curHigh==max)
                    {
                        count++;
                    }
                }
                sum+=count;
            }
            System.out.println(sum);

        }
    }
}
