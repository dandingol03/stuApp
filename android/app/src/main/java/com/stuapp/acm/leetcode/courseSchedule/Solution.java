package com.stuapp.acm.leetcode.courseSchedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static android.R.attr.path;

public class Solution {

    /**
     * 有向图的出入度表示,若 graph[i][j]==1,则代表i->j
     * 1.不能用bfs做，采用dfs代替,设置已访问点
     */
    static int[][] graph;

    static boolean isBackEdgeExist=false;


    //深度遍历，用染色来区别边
    private static boolean dfs(Integer i,List<Integer> points)
    {
        for(int j=0;j<graph.length;j++)
        {
            if(graph[i][j]==1)
            {
                if(points.contains(j))
                {
                    return false;
                }
                else{

                    points.add(j);
                    if(!dfs(j,points))
                        return false;
                    graph[i][j]=0;
                    points.remove(points.size()-1);
                }
            }

        }
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean result=false;
        if(prerequisites.length==0)
            return true;
        //初始化graph数组
        graph=new int[numCourses][];
        for(int i=0;i<numCourses;i++)
            graph[i]=new int[numCourses];


        for(int i=0;i<prerequisites.length;i++)
        {
            int[] edge=prerequisites[i];
            graph[edge[1]][edge[0]]=1;

        }


        for(int i=0;i<graph.length;i++)
        {



            List<Integer> path=new ArrayList<>();
            path.add(i);
            if(!dfs(i,path))
                return false;
        }

        return true;

    }
}
