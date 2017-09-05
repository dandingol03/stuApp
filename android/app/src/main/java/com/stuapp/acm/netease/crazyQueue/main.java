package com.stuapp.acm.netease.crazyQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class main {

    private static int[] arr;
    private static List<Integer> ans=new ArrayList<>();
    private static int crazy=0;

    private static int getAbs(int a,int b)
    {
        if(a>=b)
            return a-b;
        else
            return b-a;
    }

    private static void makeCrazy(int index)
    {
        int high=arr[index];
        if(index==0)
        {
            ans.add(high);
        }
        else{
            int max=0;
            max=getAbs(high,ans.get(0));

            int j=-1;

            for(int i=1;i<ans.size();i++)
            {
                int prev=ans.get(i-1);
                int next=ans.get(i);
                if(getAbs(high,prev)+getAbs(high,next)-getAbs(prev,next)>max)
                {
                    max=getAbs(high,prev)+getAbs(high,next)-getAbs(prev,next);
                    j=i;
                }
            }


            if(getAbs(high,ans.get(ans.size()-1))>max)
            {
                max=getAbs(high,ans.get(ans.size()-1));
                ans.add(high);
            }else{
                if(j==-1)
                    ans.add(0,high);
                else{
                    ans.add(j,high);
                }
            }

            crazy+=max;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            int n=Integer.valueOf(sc.nextLine());
            arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            for(int i=0;i<n;i++)
                makeCrazy(i);

        }

    }
}
