package com.stuapp.acm.netease.blendColor;


import java.util.Scanner;

public class main {

    static int[][] bitArray;

    public static int gauss()
    {
        int k=0;
        for(int row=0;row<31;row++)
        {
            int[] line=bitArray[row];
            int column=0;
            while(column<31)
            {
                if(line[column]==1)
                    break;
                else
                    column++;
            }
            if(column==31)//所有列中均没有位1
            {
            }else{
                if(k==row)
                {
                }else{
                    //swap k and i
                    int []temp=new int[31];
                    for(int j=0;j<31;j++)
                        temp[j]=bitArray[k][j];

                    for(int j=0;j<31;j++)
                        bitArray[k][j]=bitArray[row][j];

                    for(int j=0;j<31;j++)
                        bitArray[row][j]=temp[j];
                }
                //对k行下的所有行数据进行高斯消元
                for(int remain=k+1;remain<31;remain++)
                {
                    int[] remainLine=bitArray[remain];
                    for(int j=0;j<31;j++)
                        remainLine[j]=remainLine[j]^bitArray[k][j];
                }
                k++;
            }
        }


        return k;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n = sc.nextInt();

            //xi<=1000000000,故可以用2^31去表示
            bitArray=new int[31][];
            for(int i=0;i<31;i++)
                bitArray[i]=new int[31];

            //处理输入
            for(int i=0;i<n;i++)
            {
                int number=sc.nextInt();
                //生成二进制矩阵 a)从左至右->高位至低位
                for(int k=30;k>0;k--)
                {
                    bitArray[i][k]=number&1;
                    number=number>>1;
                }
            }

            //高斯消元
            int r=gauss();
            System.out.println(r);

        }
        sc.close();

    }
}
