package com.stuapp.acm.climbingStairs;

public class Solution {

    private int[]c;

    private void dp(int n)
    {
        for(int i=2;i<n;i++)
            c[i]=c[i-1]+c[i-2];
    }

    public int climbStairs(int n) {
        if(n==1)
        {
            return 1;
        }
        c=new int[n];
        c[0]=1;
        c[1]=2;
        dp(n);
        return c[n-1];
    }
}
