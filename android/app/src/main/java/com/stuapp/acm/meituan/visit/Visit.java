package com.stuapp.acm.meituan.visit;

public class Visit {

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point manager;
    static Point business;
    static int[][] ans;//ans存放着由初始点到目的地的走法计数

    public int  countPath(int[][] map,int n,int m)
    {

        //map,长为n,宽为m
        ans=new int[m][];
        for(int i=0;i<m;i++)
            ans[i]=new int[n];

        //首先确定经理和商家的家
        for(int j=0;j<m;j++)
        {
            for(int i=0;i<n;i++)
            {
                if(map[j][i]==1)//经理
                    manager=new Point(i,j);
                else if(map[j][i]==2)//商家
                    business=new Point(i,j);
                else if(map[j][i]==-1)
                    ans[j][i]=0;
            }
        }

        //迭代递推式
        int stepX=manager.x>business.x?1:-1;
        int stepY=manager.y>business.y?1:-1;

        ans[manager.x][manager.y]=1;

        for(int i=manager.x+1;i<business.x;i=i+stepX)
            ans[i][manager.y]=1;

        for(int j=manager.y+1;j<business.y;j=j+stepY)
            ans[manager.x][j]=1;


        //最外层迭代行
        for(int i=manager.y+1;i<=business.y;i=i+stepY)
        {
            for(int j=manager.x+1;j<=business.x;j=j+stepX)
            {
                ans[i][j]=ans[i-1][j]+ans[i][j-1];
            }
        }




        return ans[business.x][business.y];
    }
}
