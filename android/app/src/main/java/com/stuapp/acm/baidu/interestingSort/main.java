package com.stuapp.acm.baidu.interestingSort;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=Integer.valueOf(sc.nextLine());
            int[] arr=new int[n];
            int[] sort=new int[n];

            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
                sort[i]=arr[i];
            }
            Arrays.sort(sort);

            int count=0;
            for(int i=0;i<n;i++)
            {
                if(sort[i]!=arr[i])
                    count++;
            }
            System.out.println(count);


        }
    }
}
