package com.stuapp.acm.nextPremutation;


public class Solution {


    public void nextPermutation(int[] nums) {

        if(nums!=null&&nums.length>0)
        {
            for(int j=nums.length-2;j>=0;j--)
            {
                if(nums[j]<nums[j+1])
                {
                    int p=j+1;
                    int min=j+1;
                    while(p<nums.length-1)
                    {
                      if(nums[p]<min)
                          min=p;
                        p++;
                    }
                    if(min<nums.length)
                    {
                        //TODO:switch min with j
                        int temp=nums[j];
                        nums[j]=nums[min];
                        nums[min]=temp;
                    }
                }
            }
        }

    }
}
