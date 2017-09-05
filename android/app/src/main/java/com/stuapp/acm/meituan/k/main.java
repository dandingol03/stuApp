package com.stuapp.acm.meituan.k;


import java.util.Scanner;

public class main {

    static int[][] c;
    static int[][] b;

    static void dp(int[] inputs,int k)
    {
        for(int step=1;step<=inputs.length;step++)
        {
            for(int i=0;i<inputs.length;i++)
            {
                for(int j=i+1;j<i+step;j++)
                {
                    if(j<inputs.length)
                    {
                        c[i][j]=c[i][j-1]+inputs[j];
                        if(c[i][j]%k==0)
                            b[i][j]=j-i+1;
                        else
                            b[i][j]=b[i][j-1];
                    }
                }
            }
        }

    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            int n=sc.nextInt();
            int[] inputs=new int[n];
            for(int i=0;i<n;i++)
            {
                inputs[i]=sc.nextInt();
            }
            int k=sc.nextInt();
            //初始化c
            c=new int[n][];
            b=new int[n][];
            for(int i=0;i<n;i++)
            {
                c[i]=new int[n];
                b[i]=new int[n];
                c[i][i]=inputs[i];
                if(inputs[i]%k==0)
                    b[i][i]=1;
                else
                    b[i][i]=0;
            }

            dp(inputs,k);
            System.out.println(b[0][inputs.length-1]);
        }
    }
}
