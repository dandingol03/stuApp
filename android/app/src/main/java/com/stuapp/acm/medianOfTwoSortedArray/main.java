package com.stuapp.acm.medianOfTwoSortedArray;


public class main {
    public static void main(String[] args)
    {
        Solution solution=new Solution();
        double d=solution.findMedianSortedArrays(new int[]{1,2,4},new int[]{3});
        System.out.println(d);
    }
}
