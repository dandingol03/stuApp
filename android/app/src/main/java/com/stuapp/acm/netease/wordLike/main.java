package com.stuapp.acm.netease.wordLike;

import java.util.HashMap;
import java.util.Scanner;

public class main {

    private static boolean judgeAdjacent(String word)
    {
        for(int i=0;i<word.length()-1;i++)
        {
            if(word.charAt(i)==word.charAt(i+1))
                return true;
        }
        return false;
    }

    private static boolean judgeInWhole(String word)
    {


        for(int j=0;j<word.length();j++)
        {
            int i=0;
            HashMap<String,Integer> keys=new HashMap<>();
            boolean flag=false;
            while(i<j)
            {
                if(word.charAt(i)==word.charAt(j))
                {
                    flag=true;
                    break;
                }
                else
                {
                    if(!keys.containsKey(word.substring(i,i+1)))
                        keys.put(word.substring(i,i+1),1);
                    i++;
                }
            }
            if(flag&&i!=0)
            {
                int k=j-1;
                while(k>i)
                {
                    if(keys.containsKey(word.substring(k,k+1)))
                        return true;
                    k--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        boolean result=false;
        while(in.hasNext())
        {
            String word=in.nextLine();
            result=judgeAdjacent(word);
            if(!result)
            {
                result=judgeInWhole(word);
                if(result)
                    System.out.println("Dislikes");
                else
                    System.out.println("Likes");
            }else{
                System.out.println("Dislikes");
            }
        }
    }
}
