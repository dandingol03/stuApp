package com.stuapp.acm.meituan.flip;


public class Flip {
    public int[][] flipChess(int[][] A,int[][] f)
    {
        for(int i=0;i<f.length;i++)
        {
            int[] point=f[i];
            int x=point[0];
            int y=point[1];
            A[x-1][y-1]=1-A[x-1][y-1];
        }
        return A;
    }
}
