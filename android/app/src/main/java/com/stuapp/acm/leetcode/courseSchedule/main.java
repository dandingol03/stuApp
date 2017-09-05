package com.stuapp.acm.leetcode.courseSchedule;


public class main {
    public static void main(String[] args)
    {
        DfsSolution solution=new DfsSolution();
        int[][] inputs=new int[7][];
        inputs[0]=new int[]{1,0};
        inputs[1]=new int[]{2,6};
        inputs[2]=new int[]{1,7};
        inputs[3]=new int[]{5,1};
        inputs[4]=new int[]{6,4};
        inputs[5]=new int[]{7,0};
        inputs[6]=new int[]{0,5};
        boolean re= solution.canFinish(8,inputs);
        System.out.println(re);
    }
}
