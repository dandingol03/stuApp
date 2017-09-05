package com.stuapp.acm.netease.dungeon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static android.R.attr.y;

public class main {

    static int m,n;
    static int x0,y0;
    static int stepTypes;
    static int dx[] = new int[50], dy[] = new int[50];
    static Point[][] map=new Point[50][50];

    static {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]= new Point();
            }
        }
    }

    //图遍历
    public static int bfs()
    {
        Queue<Point> queue=new LinkedList<>();
        //初始化时step设置为0
        Point startPoint=new Point(x0,y0,0);
        map[x0][y0].visited=true;
        queue.add(startPoint);
        int maxSteps = 0;

        //a) 当队列不为空，代表所有的点还没有遍历完
        //b) 每次遍历获取目标到初始点的最短距离

        while(!queue.isEmpty())
        {
            Point p=queue.poll();
            //保存最大步数记录,以便结果输出
            maxSteps=Math.max(p.step,maxSteps);



        }


        return 0;
    }

    public static void main(String[] args)
    {
        Scanner sin=new Scanner(System.in);
        while(sin.hasNext())
        {
            //n row ,m column
            n=sin.nextInt();
            m=sin.nextInt();

            for(int i=0;i<n;i++)
            {
                String line=sin.nextLine();
                for(int j=0;j<m;j++)
                    if(line.charAt(j)=='.')
                        map[i][j].reachable=true;
            }

            x0 = sin.nextInt();
            y0 = sin.nextInt();

            //合法布长，其实相当于走下一步的方案
            stepTypes = sin.nextInt();

            for (int i = 0; i < stepTypes; i++) {
                dx[i] = sin.nextInt();
                dy[i] = sin.nextInt();
            }
            int result = bfs();

        }
    }
}
