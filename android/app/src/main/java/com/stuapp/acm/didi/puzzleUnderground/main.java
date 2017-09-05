package com.stuapp.acm.didi.puzzleUnderground;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import static android.R.attr.x;
import static android.R.attr.y;


public class main {

    static int[][]graph;
    static int n;
    static int m;
    static boolean successful;
    static List<Point> successfulPath;
    static Stack<Point> visitedPath;

    /**
     * 尝试用dp去解决,设置终点为起点 dp[i][j]=> a)dp[i-1]
     * @param x
     * @param y
     * @param p
     */

    private static void dfs(int x,int y,int p)
    {
        if(x==m-1&&y==0&&p>=0)
        {
            if(successfulPath.size()==0)
            {
                for(int i=0;i<visitedPath.size();i++)
                {
                    Point cur=visitedPath.get(i);
                    successfulPath.add(cur);
                }

            }else{
                if(successfulPath.size()>visitedPath.size())
                {
                    for(int i=0;i<visitedPath.size();i++)
                    {
                        Point cur=visitedPath.get(i);
                        successfulPath.add(cur);
                    }
                }
            }
            successful=true;
        }
        else{
            //如果体力耗尽结束行走
            if(p<=0)
                return ;

            //往下走
            if(y<n-1&&graph[y+1][x]==1)
            {
                Point point1=new Point(x,y+1);
                if(visitedPath.contains(point1))
                    return;
                else{
                    visitedPath.push(point1);
                    dfs(x,y+1,p);
                    visitedPath.pop();
                }
            }

            //往上走
            if(y>0&&graph[y-1][x]==1)
            {
                Point point1=new Point(x,y-1);
                if(visitedPath.contains(point1))
                    return;
                else{
                    visitedPath.push(point1);
                    dfs(x,y-1,p-3);
                    visitedPath.pop();
                }
            }

            //往左走
            if(x>0&&graph[y][x-1]==1)
            {
                Point point1=new Point(x-1,y);
                if(visitedPath.contains(point1))
                    return;
                else{
                    visitedPath.push(point1);
                    dfs(x-1,y,p-1);
                    visitedPath.pop();
                }
            }

            //往右走
            if(x<m-1&&graph[y][x+1]==1)
            {
                Point point1=new Point(x+1,y);
                if(visitedPath.contains(point1))
                    return;
                else{
                    visitedPath.push(point1);
                    dfs(x+1,y, p-1);
                    visitedPath.pop();
                }
            }

        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            n=sc.nextInt();
            m=sc.nextInt();
            int p=sc.nextInt();
            successful=false;
            successfulPath=new ArrayList<>();
            visitedPath=new Stack<>();
            graph=new int[n][];
            for(int i=0;i<n;i++)
                graph[i]=new int[m];

            //i代表行,j代表列
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    graph[i][j]=sc.nextInt();
                }
            }


            //貌似dfs超时，改用非递归的dfs
            visitedPath.push(new Point(0,0));
            int curP=p;
            while (!visitedPath.empty())
            {
                Point point=visitedPath.pop();
                //todo:改造成非递归
                if(point.x==m-1&&point.y==0&&curP>=0)
                {
                    if(successfulPath.size()==0)
                    {
                        for(int i=0;i<visitedPath.size();i++)
                        {
                            Point cur=visitedPath.get(i);
                            successfulPath.add(cur);
                        }

                    }else{
                        if(successfulPath.size()>visitedPath.size())
                        {
                            for(int i=0;i<visitedPath.size();i++)
                            {
                                Point cur=visitedPath.get(i);
                                successfulPath.add(cur);
                            }
                        }
                    }
                    successful=true;
                }
                else{
                    //如果体力耗尽结束行走
                    if(p<=0)
                        return ;

                    //往下走
                    if(y<n-1&&graph[y+1][x]==1)
                    {
                        Point point1=new Point(x,y+1);
                        if(visitedPath.contains(point1))
                            return;
                        else{
                            visitedPath.push(point1);
                            dfs(x,y+1,p);
                            visitedPath.pop();
                        }
                    }

                    //往上走
                    if(y>0&&graph[y-1][x]==1)
                    {
                        Point point1=new Point(x,y-1);
                        if(visitedPath.contains(point1))
                            return;
                        else{
                            visitedPath.push(point1);
                            dfs(x,y-1,p-3);
                            visitedPath.pop();
                        }
                    }

                    //往左走
                    if(x>0&&graph[y][x-1]==1)
                    {
                        Point point1=new Point(x-1,y);
                        if(visitedPath.contains(point1))
                            return;
                        else{
                            visitedPath.push(point1);
                            dfs(x-1,y,p-1);
                            visitedPath.pop();
                        }
                    }

                    //往右走
                    if(x<m-1&&graph[y][x+1]==1)
                    {
                        Point point1=new Point(x+1,y);
                        if(visitedPath.contains(point1))
                            return;
                        else{
                            visitedPath.push(point1);
                            dfs(x+1,y, p-1);
                            visitedPath.pop();
                        }
                    }

                }
            }


            if(successful)
            {
                for(int i=0;i<successfulPath.size();i++)
                {
                    System.out.print("["+successfulPath.get(i).y+","+successfulPath.get(i).x+"]");

                    if(i!=successfulPath.size()-1)
                        System.out.print(",");
                }
            }else{
                System.out.println("Can not escape!");
            }

        }
    }
}
