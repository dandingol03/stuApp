package com.stuapp.acm.palindromic;

/**
 *  回文测试分为单字符和双字符
 *  1.进行单字符
 */

public class Solution {



    private int start=0;
    private int end=0;
    boolean c[][]=null;
    private void dp(String s)
    {
        for(int step=0;step<s.length();step++)
        {

            for(int i=0;i<s.length()-step;i++)
            {
                int j=i+step;
                if(j<s.length())
                {
                    if(i==j)
                        c[i][j]=true;
                    else{
                        if(j<s.length())
                        {
                            if(step==1)
                            {
                                if(s.charAt(i)==s.charAt(j))
                                {
                                    c[i][j]=true;
                                    if(j-i+1>=end-start+1)
                                    {
                                        start=i;
                                        end=j;
                                    }
                                }else{
                                    c[i][j]=false;
                                }

                            }else{
                                if(c[i+1][j-1]==true)
                                {
                                    if(s.charAt(i)==s.charAt(j))
                                    {
                                        c[i][j]=true;
                                        if(j-i+1>=end-start+1)
                                        {
                                            start=i;
                                            end=j;
                                        }
                                    }
                                    else
                                        c[i][j]=false;
                                }else{
                                    c[i][j]=false;
                                }
                            }
                        }else{
                            c[i][j]=false;
                        }
                    }
                }
            }
        }
    }

    public String longestPalindrome(String s) {

        if(s.length()<2)
        {
            return s;
        }
        else{
            c=new boolean[s.length()][];
            for(int i=0;i<s.length();i++)
            {
                c[i]=new boolean[s.length()];
            }
            //Dynamic programming 线性规划
            dp(s);
        }
        return s.substring(start,end+1);
    }
}
