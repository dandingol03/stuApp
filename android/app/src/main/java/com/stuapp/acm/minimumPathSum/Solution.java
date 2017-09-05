package com.stuapp.acm.minimumPathSum;



public class Solution {

    private int[][]c;

    private void dp(int m,int n,int[][] grid)
    {
        for(int i=0;i<m;i++)
        {
          for(int j=0;j<n;j++)
          {
              if(i==0&&j==0)
              {
                  c[i][j]=grid[0][0];
              }else if(i==0)
              {
                  c[i][j]=c[0][j-1]+grid[i][j];
              }else if(j==0)
              {
                  c[i][j]=c[i-1][0]+grid[i][j];
              }else{
                  c[i][j]=Math.min(c[i-1][j],c[i][j-1])+grid[i][j];
              }

          }
        }
    }

    public int minPathSum(int[][] grid) {


        if(grid!=null)
        {
            //suppose grid is 3x2 array
            c=new int[grid.length][];
            for(int i=0;i<grid.length;i++)
                c[i]=new int[grid[0].length];



            dp(grid.length,grid[0].length,grid);


        }else{}


        return c[grid.length-1][grid[0].length-1];
    }
}
