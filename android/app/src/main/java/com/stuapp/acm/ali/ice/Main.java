package com.stuapp.acm.ali.ice;


import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            int n=Integer.valueOf(sc.nextLine());
            char [][]c=new char[n][];
            for(int i=0;i<n;i++)
            {
                c[i]=new char[n];
            }

            int ans=0;
            for(int i=0;i<n;i++)
            {
                String line=sc.nextLine();
                for(int j=0;j<n;j++)
                    c[i][j]=line.charAt(j);
            }

            //todo:逻辑开始
            for(int i=0;i<n;i++)
            {

                int j=0;
                //用于指示前一步是否为油田
                boolean previous=false;
                while(j<n)
                {

                    if(c[i][j]=='*')
                    {
                        if((i-1>=0&&c[i-1][j]=='*')||
                                (j-1>=0&&c[i][j-1]=='*')||
                                (i-1>=0&&j-1>=0&&c[i-1][j-1]=='*')
                                )
                        {
                            if(j-1>=0&&c[i][j-1]=='*')
                            {}
                            else
                                previous=false;
                        }
                        else{

                            if(previous)
                            {
                            }else{
                                previous=true;
                            }
                            if(j==n-1)
                            {
                                ans++;
                                break;
                            }

                        }
                        j++;
                    }else{
                        //如果先前为油田
                        if(previous)
                        {
                            if(i-1>=0&&c[i-1][j]=='*')
                            {
                            }else{
                                ans++;
                            }
                            previous=false;
                        }
                        j++;
                    }

                }

            }
            System.out.println(ans);

        }
    }
}
