package com.stuapp.acm.leetcode.courseSchedule;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static android.media.CamcorderProfile.get;

public class BfsSolution {
    static int[][] graph;



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
        //1.当vertextCount为0时,代表所有结点都已成功遍历
        int vertextCount=numCourses;

        List<Integer> roots=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            if(indegrees[i]==0)
                roots.add(i);
        }

        for(int k=0;k<roots.size();k++)
        {
            int i=roots.get(k);
            //bfs
            Queue<Integer> queue=new LinkedList<>();
            queue.add(i);
            //当队列不为空时
            while (!queue.isEmpty())
            {
                Integer vertext=queue.poll();
                //本结点入度已为0
                if(indegrees[vertext]==0)
                    vertextCount--;
                for(int j=0;j<graph.length;j++)
                {
                    if(graph[vertext][j]==1)
                    {
                        indegrees[j]--;
                        if(indegrees[j]==0)
                            queue.add(j);
                    }

                }
            }

        }

        return vertextCount==0;

    }
}
