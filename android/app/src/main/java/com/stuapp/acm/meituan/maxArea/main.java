package com.stuapp.acm.meituan.maxArea;


import java.util.Scanner;

public class main {

    static int[] arr;

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=Integer.valueOf(sc.nextLine());
            arr=new int[n];
            int lowest=Integer.MAX_VALUE;
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
                if(arr[i]<lowest)
                    lowest=arr[i];
            }

            int i=0;
            int j=n-1;
            int max=lowest*(n-1);
            while(i<j)
            {
                int min=arr[i];
                for(int k=i+1;k<=j;k++)
                    if(arr[k]<min)
                        min=arr[k];
                int area=min*(j-i);
                if(area>=max)
                {
                    max=area;
                    i++;
                }

                if(i<j)
                {
                    min=arr[j];
                    for(int k=j-1;k>=i;k--)
                        if(arr[k]<min)
                            min=arr[k];
                    area=min*(j-i);
                    if(area>=max)
                    {
                        max=area;
                        j--;
                    }
                }else{
                    break;
                }

            }


            System.out.println(max);


        }
    }
}
