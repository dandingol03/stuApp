package com.stuapp.acm.meituan3.biggestDiff;


public class LongestDistance {
    public int getDis(int[] A, int n) {

        int diff=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(A[i]<min)
                min=A[i];
            else{
                if(A[i]-min>diff)
                    diff=A[i]-min;
            }
        }

        return diff;
    }
}
