package com.stuapp.acm.regularExpressionMatching;


public class Solution {

    private boolean c[][]=null;

    private void dp(String s,String p)
    {
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<p.length();j++)
            {
                if(p.charAt(j)=='.')
                    c[i+1][j+1]=c[i][j];
                else if(s.charAt(i)==p.charAt(j))
                    c[i+1][j+1]=c[i][j];
                else{
                    if(p.charAt(j)=='*')
                    {
                        //匹配
                        if(p.charAt(j-1)==s.charAt(i)||p.charAt(j-1)=='.')
                        {
                            //匹配多个或者单个,优先短路的属性，最后一个是针对s无字符的情况
                            c[i+1][j+1]=c[i+1][j]||c[i][j+1]||c[i+1][j-1];

                        }else{
                            //不匹配
                            c[i+1][j+1]=c[i+1][j-1];
                        }
                    }
                }
            }
        }

    }

    public boolean isMatch(String s, String p) {


        //初始化二维数组
        c=new boolean[s.length()+1][];
        for(int i=0;i<=s.length();i++)
        {
            c[i]=new boolean[p.length()+1];
        }
        //无用点
        c[0][0]=true;

        dp(s,p);


        return c[s.length()][p.length()];
    }
}
