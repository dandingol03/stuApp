package com.stuapp.acm.longestSubstring;


import static android.R.attr.max;

public class Solution {

    private boolean[][]c=null;
    private int maxCount=1;

    //自底向上,n^2/2的时间复杂度
    public void computeSubstring(String s)
    {

        for(int step=0;step<=s.length();step++)
        {
            for(int i=0;i<s.length()-step;i++)
            {

                int j=i+step;
                if(j==i)
                {
                    c[i][j]=true;
                }else{

                    if(!c[i][j-1])
                        c[i][j]=false;
                    else{
                        CharSequence curChar=s.substring(j,j+1);

                        String subString=s.substring(i,j);

                        if(subString.contains(curChar))
                            c[i][j]=false;
                        else
                        {
                            c[i][j]=true;
                            if(j-i+1>maxCount)
                                maxCount=j-i+1;
                        }
                    }
                }


            }
        }
    }


    public int lengthOfLongestSubstring(String s) {

        //初始化二维数组
        c=new boolean[s.length()][];
        for(int i=0;i<s.length();i++)
        {
            c[i]=new boolean[s.length()];
        }
        for(int i=0;i<s.length();i++)
        {
            c[i][i]=true;
        }

        //开始计算子问题
        computeSubstring(s);

        if(s.length()==0)
            return 0;

        return maxCount;
    }
}
