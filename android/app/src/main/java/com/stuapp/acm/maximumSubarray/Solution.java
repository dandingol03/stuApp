package com.stuapp.acm.maximumSubarray;


public class Solution {


    private int c[];

    public int maxSubArray(int[] nums) {

        int res=0;
        c=new int[nums.length];
        if(nums!=null&&nums.length>0)
        {
            c[0]=nums[0];
            res=c[0];
            for(int i=1;i<nums.length;i++)
            {

                if(c[i-1]>=0)
                {
                    c[i]=c[i-1]+nums[i];
                }else{
                    c[i]=nums[i];
                }
                if(c[i]>=res)
                    res=c[i];
            }
        }else{
        }

        return res;
    }
}
