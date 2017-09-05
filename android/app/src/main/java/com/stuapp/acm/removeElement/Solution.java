package com.stuapp.acm.removeElement;


public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums!=null&&nums.length>0)
        {
            int i=0;
            int j=0;
            while(j<nums.length)
            {
                if(nums[j]!=val)
                {
                    nums[i++]=nums[j];
                }
                j++;
            }
            while(i<nums.length)
                nums[i++]=val;
            return i+1;
        }
        return 0;
    }
}
