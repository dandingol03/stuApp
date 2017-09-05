package com.stuapp.acm.regularExpressionMatching;


import com.stuapp.acm.longestSubstring.*;

public class main {
    public static void main(String[] args)
    {
        Solution solution=new Solution();
        boolean re=solution.isMatch("aab","c*a*b");
        System.out.println(re);
    }
}
