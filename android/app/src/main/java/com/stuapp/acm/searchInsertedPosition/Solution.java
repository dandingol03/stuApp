package com.stuapp.acm.searchInsertedPosition;



public class Solution {
    public int searchInsert(int[] nums, int target) {

        if(nums!=null&&nums.length>0)
        {
            for(int i=0;i<nums.length;i++)
            {

                if(nums[i]==target)
                    return i;
                if(i!=0&&nums[i]>target&&nums[i-1]<target)
                    return i;
                if(i==nums.length-1&&nums[i]<target)
                {
                    return nums.length;
                }
            }
        }
        return 0;
    }
}
