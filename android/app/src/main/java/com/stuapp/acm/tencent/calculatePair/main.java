package com.stuapp.acm.tencent.calculatePair;

import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=Integer.valueOf(sc.nextLine());
            int[] arr=new int[n];

            int sum=0;
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
                sum+=arr[i];
            }
            int average=sum/n;
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            int bigCount=0;
            int smallCount=0;


            if(n<=2)
            {

            }else{
                //todo:计算差最大pair
                for(int i=0;i<n;i++)
                {
                    int dis=arr[i]-average;
                    if(dis>=0)
                    {
                        if(dis>max)
                        {
                            max=dis;
                            bigCount=1;
                        }else if(dis==max){
                            bigCount++;
                        }
                    }

                    if(dis<0)
                    {
                        if(dis<min)
                        {
                            min=dis;
                            smallCount=1;
                        }else if(dis==min)
                        {
                            smallCount++;
                        }
                    }
                }

                if(max==min)
                {
                    System.out.print(1);
                    System.out.print(" ");
                    System.out.print(1);
                }else{

                    System.out.print(" ");
                    System.out.print(bigCount*smallCount);

                }


            }


        }
    }
}
