package com.stuapp.acm.meituan3.byteEncode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            String line=sc.nextLine();

            List<Node> list=new ArrayList<>();

            //获得各个字母的频数
            HashMap<String,Integer> charMaps=new HashMap<>();
            for(int i=0;i<line.length();i++)
            {
                String key=line.substring(i,i+1);
                if(charMaps.containsKey(key))
                    charMaps.put(key,charMaps.get(key)+1);
                else
                    charMaps.put(key,1);
            }

            //插入链表
            Iterator iterator= charMaps.entrySet().iterator();
            while (iterator.hasNext())
            {
                Map.Entry entry =(Map.Entry) iterator.next();
                Node node=new Node((char)entry.getKey());
                node.weight=(int)entry.getValue();
                list.add(node);
            }

            //进行归并
            while(list.size()>1)
            {
                //遍历链表,取得权重最小的2个结点
                Node pre=list.get(0).weight<list.get(1).weight?list.get(0):list.get(1);
                Node cur=list.get(0).weight<list.get(1).weight?list.get(1):list.get(0);
               for(int i=2;i<list.size();i++)
               {
                   //更新pre和cur
                   if(list.get(i).weight<pre.weight)
                       pre=list.get(i);
                   else if(list.get(i).weight<cur.weight)
                       cur=list.get(i);
                   else
                   {}
               }
                //合并pre和cur,同时将其从list中移除
                Node merged=new Node();
                merged.weight=pre.weight+cur.weight;
                //todo:查看算法是否有递推式
                merged.pathWeight=pre.pathWeight+cur.pathWeight+2;
                list.remove(pre);
                list.remove(cur);
                list.add(merged);
            }

            System.out.println(list.get(0).pathWeight);

        }
    }
}
