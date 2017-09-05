package com.stuapp.acm.strStr;


public class Solution {
    public int strStr(String haystack, String needle) {

        if(needle!=null&&haystack!=null&&!haystack.equals(""))
        {
            int i=0;

            while(i<haystack.length())
            {
                if(haystack.charAt(i)!=needle.charAt(0))
                    i++;
                else{
                    int p=i;
                    int j=0;
                    while(j<needle.length())
                    {
                        if(needle.charAt(j)==haystack.charAt(p))
                        {
                            j++;
                            p++;
                        }else{
                            break;
                        }
                    }
                    //匹配完成
                    if(j==needle.length())
                        return i;
                    else
                        i++;
                }
            }
        }

        return -1;
    }
}
