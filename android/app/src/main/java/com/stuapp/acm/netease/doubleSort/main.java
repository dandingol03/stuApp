package com.stuapp.acm.netease.doubleSort;


import java.util.Scanner;

public class main {



    static int n;
    static String[] arr;

    private static String compareString(String str1,String str2)
    {
        int i=str1.length();
        int j=str2.length();
        if(i<=j)//符合长度排序
        {
            for(int k=0;k<i;k++)
            {
                if(str1.charAt(k)<str2.charAt(k))
                    return "both";
                if(str1.charAt(k)>str2.charAt(k))
                    return "lengths";
            }
            return "both";
        }else{
            //检查是否按字典排序

            for(int k=0;k<j;k++)
            {
                if(str1.charAt(k)<str2.charAt(k))
                    return "lexicographically";
                if(str1.charAt(k)>str2.charAt(k))
                    return "none";
            }
            return "none";
        }

    }

    private static String compare()
    {

        String previous="both";
        for(int i=0;i<n-1;i++)
        {
            String word1=arr[i];
            String word2=arr[i+1];
            String  result=compareString(word1,word2);
            if(previous.equals("none"))
                return "none";
            if(result.equals(previous))
            {
            }else{
                if(previous.equals("both"))
                    previous=result;
                else if(result.equals("both"))
                {}
                else{
                    previous="none";
                }
            }
        }
        return  previous;

    }

    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        while(in.hasNext())
        {
            n=Integer.valueOf(in.nextLine());
            arr=new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=in.nextLine();
            }

            String re=compare();
            System.out.println(re);
        }
    }
}
