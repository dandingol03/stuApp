package com.stuapp.acm.netease.hungryEase;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main {

    static class Node{

        long step;
        long value;

        public Node(long value, long step) {
            this.value = value;
            this.step = step;
        }

        public Node() {
        }
    }

    private static long x0;

    private static long  bfs()
    {
        //初始化
        Queue<Node> q=new LinkedList<>();
        Node t=new Node(x0,0);
        q.add(t);

        while(!q.isEmpty())
        {
            Node p=q.poll();
            if(p.step>=100000)
                return -1;

            if(p.value%1000000007==0)
            {
                return p.step;
            }else{
                Node t1=new Node(p.value*4+3,p.step+1);
                q.add(t1);
                Node t2=new Node(p.value*8+7,p.step+1);
                q.add(t2);
            }
            p=null;

        }

        return -1;
    }

    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        while(in.hasNext())
        {
            x0=in.nextLong();
            long step=bfs();
            System.out.println(step);
        }
    }
}
