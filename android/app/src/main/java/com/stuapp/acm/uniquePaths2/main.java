package com.stuapp.acm.uniquePaths2;



public class main {
    public static void main(String[] args)
    {
        Solution solution=new Solution();
        int[][] inputs=new int[3][];
        inputs[0]=new int[]{0,0,0};
        inputs[1]=new int[]{0,1,0};
        inputs[2]=new int[]{0,0,0};
        solution.uniquePathsWithObstacles(inputs);
    }
}
