package com.stuapp.acm.meituan.longestSubString;


import java.util.Scanner;

public class main {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String A=sc.nextLine();
            String B=sc.nextLine();



            int max=0;
            if(A.length()<=B.length())//A为短串
            {
                for(int i=0;i<A.length();i++)
                {
                    int jStep=0;
                    int j=0;
                    int k=i;
                    int count=0;
                    //等待j遍历完B串
                    while(j<B.length()&&k<A.length())
                    {
                        char ac=A.charAt(k);
                        char bc=B.charAt(j);
                        if(ac==bc)
                        {
                            count++;
                            k++;
                            j++;
                            if(count>max)
                                max=count;
                        }else{
                            k=i;
                            count=0;
                            jStep++;
                            while(jStep<B.length()&&B.charAt(jStep)!=A.charAt(k))
                            {
                                jStep++;
                            }
                            j=jStep;
                        }
                    }

                }
            }else{
                for(int i=0;i<B.length();i++)
                {

                    int jStep=0;
                    int j=0;
                    int k=i;
                    int count=0;
                    //等待j遍历完A串
                    while(j<A.length()&&k<B.length())
                    {
                        char bc=B.charAt(k);
                        char ac=A.charAt(j);
                        if(ac==bc)
                        {
                            count++;
                            k++;
                            j++;
                            if(count>max)
                                max=count;
                        }else{
                            k=i;
                            count=0;
                            jStep++;
                            //自动过滤
                            while(jStep<A.length()&&A.charAt(jStep)!=B.charAt(k))
                            {
                                jStep++;
                            }
                            j=jStep;

                        }
                    }

                }
            }
            System.out.println(max);

        }
    }
}
