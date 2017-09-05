package com.stuapp.acm.netease.rescueEase;


import java.util.Scanner;

public class main {

    static int[] dx;
    static int[] dy;
    static int n;

    static int getMinimum()
    {
        int minimum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int step=Math.abs(dx[i]-1);
            step+=Math.abs(dy[i]-1);
            if(step<minimum)
                minimum=step;
        }

        return minimum;
    }

    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        dx=new int[n];
        dy=new int[n];

        for(int i=0;i<n;i++)
        {
            int number=in.nextInt();
            dx[i]=number;
        }

        for(int j=0;j<n;j++)
        {
            int number=in.nextInt();
            dy[j]=number;
        }

        //todo:calculate the minimum seconds when ease get into troublue
        int step=getMinimum();
        System.out.println(step);

    }
}
