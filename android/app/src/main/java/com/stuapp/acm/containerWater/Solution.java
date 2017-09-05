package com.stuapp.acm.containerWater;


import static android.R.attr.x;

public class Solution {

    private int volumn=0;
    private int pivotX=0;
    private int pivotY=0;
    private int minist(int []height)
    {
        int i=0;
        int j=height.length-1;
        pivotY=j;

        while(i<=j)
        {

            volumn=Math.max((j-i)*Math.min(height[j],height[i]),volumn);
            if(height[j]>height[i]) {
                i++;
            }else{
                j--;
            }

        }
        return volumn;

    }

    public int maxArea(int[] height) {
       return  minist(height);

    }
}
