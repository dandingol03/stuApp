package com.stuapp.acm.threeSumCloest;


import java.util.Arrays;

import static android.R.attr.pivotX;
import static android.R.attr.pivotY;

public class Solution {

    private int distance=Integer.MAX_VALUE;
    private int pivot1=0;
    private int pivot2=0;
    private int pivot3=0;

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++)
        {
            if(i==0||nums[i]!=nums[i-1])
            {
                int sum=target-nums[i];
                int j=i+1;
                int p=nums.length-1;

                //如果有更新
                while(j<p)
                {
                    if(Math.abs(sum-nums[j]-nums[p])<distance)
                    {
                        distance=Math.abs(sum-nums[j]-nums[p]);
                        pivot1=i;
                        pivot2=j;
                        pivot3=p;
                        if(nums[j]+nums[p]<sum)
                        {
                            j++;
                        }
                        else
                        {
                            p--;
                        }
                    }else{
                        if(nums[j]+nums[p]>sum)
                            p--;
                        else
                            j++;
                    }
                }
            }
        }

        return nums[pivot1]+nums[pivot2]+nums[pivot3];
    }
}
