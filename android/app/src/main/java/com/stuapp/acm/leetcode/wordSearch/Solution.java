package com.stuapp.acm.leetcode.wordSearch;


import java.util.ArrayList;
import java.util.List;


public class Solution {

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }

    static boolean matched=false;

    private boolean equals(Point p1,Point p2)
    {
        if(p1.x==p2.x&&p1.y==p2.y)
            return true;
        else
            return false;
    }

    public boolean exist(char[][] board, String word) {

        matched=false;
        for(int i=0;i<board.length;i++)
        {
            //j对应x,i对应y
            for(int j=0;j<board[0].length;j++)
            {
                List<Point> paths=new ArrayList<>();
                paths.add(new Point(j,i));
                dfs(word,board,paths);
            }
        }

        return matched;
    }

    public void dfs(String word,char[][] board,List<Point> paths)
    {
        Point cur=paths.get(paths.size()-1);
        //查看是否能拼接成字符串
        if(paths.size()==word.length())
        {
            boolean flag=true;
            for(int i=0;i<word.length();i++)
            {
                if(word.charAt(i)==board[paths.get(i).y][paths.get(i).x])
                {
                }else{
                    flag=false;
                    break;
                }
            }
            if(flag)
                matched=true;

        }else{
            if(paths.size()>word.length())
            {
            }else{
                Point pl;
                Point pr;
                Point pt;
                Point pb;
                //左结点
                if(cur.x-1>=0)
                {
                    pl=new Point(cur.x-1,cur.y);
                    if(paths.contains(pl))
                    {
                    }else{
                        paths.add(pl);
                        dfs(word,board,paths);
                        paths.remove(paths.size()-1);
                    }
                }

                //右结点
                if(cur.x+1<board[0].length)
                {
                    pr=new Point(cur.x+1,cur.y);
                    if(paths.contains(pr))
                    {
                    }else{
                        paths.add(pr);
                        dfs(word,board,paths);
                        paths.remove(paths.size()-1);
                    }
                }

                //上结点
                if(cur.y-1>0)
                {
                    pt=new Point(cur.x,cur.y-1);
                    if(paths.contains(pt))
                    {}
                    else{
                        paths.add(pt);
                        dfs(word,board,paths);
                        paths.remove(paths.size()-1);
                    }
                }
                //下结点
                if(cur.y+1<board.length)
                {
                    pb=new Point(cur.x,cur.y+1);
                    if(paths.contains(pb))
                    {}
                    else{
                        paths.add(pb);
                        dfs(word,board,paths);
                        paths.remove(paths.size()-1);
                    }
                }
            }
        }




    }
}
