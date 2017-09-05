package com.stuapp.acm.netease.colorBrick;


import java.util.HashMap;
import java.util.Scanner;

public class main {

    private static int count=0;
    private static HashMap<String,Integer> colors=new HashMap<>();

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            String s=sc.nextLine();
            for(int i=0;i<s.length();i++)
            {
                if(colors.containsKey(s.substring(i,i+1)))
                    colors.put(s.substring(i,i+1),colors.get(s.substring(i,i+1)));
                else
                {
                    colors.put(s.substring(i,i+1),1);
                    count++;
                    if(count>2)
                        break;
                }
            }
            if(count>2)
                System.out.println(0);
            else{
                System.out.println(count);
            }
        }

    }
}
