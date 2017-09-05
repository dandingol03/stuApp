package com.stuapp.acm.meituan.longestDistance;


public class LongestDistance {
    public int getDis(int[] A,int n)
    {
        int dis=0;
        if(A!=null&&A.length>0)
        {
            int min=A[0];
            int i=0;
            int j=i+1;
            while(j<A.length)
            {
                if(A[j]>min)
                {
                    if(A[j]-min>dis)
                        dis=A[j]-min;
                    j++;
                }else{
                    min=A[j++];
                }
            }

        }
        return dis;
    }
}
