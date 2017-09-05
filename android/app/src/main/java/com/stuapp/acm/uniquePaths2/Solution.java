package com.stuapp.acm.uniquePaths2;


public class Solution {

    private int [][]c;

    private void dp(int m,int n,int[][] obstacleGrid)
    {
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i-1][j]!=1&&obstacleGrid[i][j-1]!=1)
                    c[i][j]=c[i-1][j]+c[i][j-1];
                else if(obstacleGrid[i-1][j]==1)
                    c[i][j]=c[i][j-1];
                else if(obstacleGrid[i][j-1]==1)
                    c[i][j]=c[i-1][j];
                else{
                    c[i][j]=0;
                }
            }
        }
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int res=0;
        if(obstacleGrid==null)
        {
        }else{
            int n=obstacleGrid.length;
            int m=obstacleGrid[0].length;
            c=new int[m][];
            for(int i=0;i<m;i++)
            {
                c[i]=new int[n];
                c[i][0]=1;
            }
            for(int i=0;i<n;i++)
                c[0][i]=1;
            //动态规划
            dp(m,n,obstacleGrid);
            res=c[m-1][n-1];

        }

        return  res;
    }
}
