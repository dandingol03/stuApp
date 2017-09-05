package com.stuapp.acm.leetcode.courseSchedule;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class DfsSolution {
    static int[][] graph;
    static List<Integer> visited=new ArrayList<>();

    static boolean dfs(int node,List<Integer> path)
    {
        if (!visited.contains(node))
        {
            visited.add(node);
        }
        for(int i=0;i<graph.length;i++)
        {
            if(graph[node][i]==1)
            {
                if(path.contains(i))
                    return false;
                else
                {
                    path.add(i);
                    if(!dfs(i,path))
                        return false;
                    path.remove(path.size()-1);
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

        //统计入度
        int[] indegrees=new int[numCourses];

        for(int i=0;i<prerequisites.length;i++)
        {
            int[] edge=prerequisites[i];
            graph[edge[1]][edge[0]]=1;
            //累加结点入度
            indegrees[edge[0]]++;
        }

        //在bfs遍历的过程中会改边图的边，所以indegreeMaps维持不变，以便记录初始时入度为0的点

        List<Integer> roots=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            if(indegrees[i]==0)
                roots.add(i);
        }

        if(roots.size()==0)
            return false;

        visited.clear();

        //如果是无环有向图,则通过每个连通分支的顶点开始遍历
        for(int k=0;k<roots.size();k++)
        {
            int i=roots.get(k);
            //dfs
            List<Integer> path=new ArrayList<>();
            path.add(i);
            if(!dfs(i,path))
                return false;
        }

        //如果在某个连通分支没有入度为0的结点，则会略过上述循环
        if(visited.size()==numCourses)
            return true;
        else
            return false;
    }
}
