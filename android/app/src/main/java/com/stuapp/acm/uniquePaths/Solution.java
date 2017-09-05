package com.stuapp.acm.uniquePaths;



public class Solution {

    private int[][]c;

    private void dp(int m,int n)
    {
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                c[i][j]=c[i-1][j]+c[i][j-1];
            }
        }
    }

    public int uniquePaths(int m, int n) {

        int res=0;
        if(m==0&&n==0)
        {
        }else{
            c=new int[m][];
            for(int i=0;i<m;i++)
            {
                c[i]=new int[n];
                c[i][0]=1;
            }
            for(int i=0;i<n;i++)
                c[0][i]=1;
            //动态规划
            dp(m,n);
            res=c[m-1][n-1];

        }
        return  res;
    }
}
