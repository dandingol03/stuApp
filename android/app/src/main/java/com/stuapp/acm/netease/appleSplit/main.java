package com.stuapp.acm.netease.appleSplit;

import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int sum=0;
        int[] cows=new int[n];
        for(int i=0;i<n;i++)
        {
            cows[i]=in.nextInt();
            sum+=cows[i];
        }

        if(n==1)
        {
            System.out.println(0);
        }else{
            if(sum%2!=0)
                System.out.println(-1);
            else{
                int average=sum/n;
                int diff=0;
                boolean failed=false;
                for(int i=0;i<n;i++)
                {
                    if(Math.abs(cows[i]-average)%2!=0)
                    {
                        failed=true;
                        break;
                    }else{
                        diff+=Math.abs(cows[i]-average);
                    }
                }
                if(failed)
                    System.out.println(-1);
                else{
                    //todo:计算需要移动的步数
                    System.out.println(diff/4);
                }
            }
        }

    }
}
